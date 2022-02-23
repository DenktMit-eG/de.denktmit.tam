package de.denktmit.tam.webapp.web;

import de.denktmit.tam.webapp.model.business.TimeSheetRecordEntity;
import de.denktmit.tam.webapp.model.business.WorkRecordEntity;
import de.denktmit.tam.webapp.service.FileSystemService;
import de.denktmit.tam.webapp.service.TimeSheetDocumentService;
import de.denktmit.tam.webapp.service.TimeSheetRecordService;
import de.denktmit.tam.webapp.service.WorkRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class UploadRestController {
    final TimeSheetRecordService timeSheetRecordService;
    final WorkRecordService workRecordService;
    final TimeSheetDocumentService timeSheetDocumentService;
    final FileSystemService fileSystemService;

    @Autowired
    public UploadRestController(TimeSheetRecordService timeSheetRecordService,
                                WorkRecordService workRecordService,
                                TimeSheetDocumentService timeSheetDocumentService, FileSystemService fileSystemService) {
        this.timeSheetRecordService = timeSheetRecordService;
        this.workRecordService = workRecordService;
        this.timeSheetDocumentService = timeSheetDocumentService;
        this.fileSystemService = fileSystemService;
    }

    @PostMapping(Routes.REST_UPLOAD)
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("workRecordId") String workRecordId,
                             RedirectAttributes attributes) {

        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Bitte wähle zuerst deine Datei aus");
            return "redirect:" + Routes.UPLOAD;
        }

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            fileSystemService.saveToUploads(file);
        } catch (IOException e) {
            attributes.addFlashAttribute("message",
                    "Beim Upload von " + fileName + " ist ein Fehler aufgetreten. ");
            System.out.println(e.getMessage());
            return "redirect:" + Routes.UPLOAD;
        }

        Optional<WorkRecordEntity> workRecord = workRecordService.findById(Long.parseLong(workRecordId));
        if(workRecord.isEmpty()){
            attributes.addFlashAttribute("message", "Beim Upload von " + fileName +
                    " ist ein Fehler aufgetreten. Die Zeitnachweis ID für Ihren Upload ist dem System nicht bekannt");
            System.out.println("WorkRecord is empty");
            return "redirect:" + Routes.UPLOAD;
        }

        try {
            List<TimeSheetRecordEntity> timeSheetRecordEntities = timeSheetRecordService.convertFilestreamToTimeSheetRecordEntities(
                    file.getInputStream(), workRecord.get().getId());
            timeSheetRecordService.deleteByWorkRecordId(workRecord.get().getId());
            timeSheetRecordService.saveAll(timeSheetRecordEntities);
            timeSheetDocumentService.saveNewTimeSheetDocument("Timesheet", fileName,
                    file.getInputStream().readAllBytes(), "username");
        } catch (IOException | IllegalArgumentException e) {
            attributes.addFlashAttribute("message", "Beim Upload von " + fileName +
                    " ist ein Fehler aufgetreten. " + e.getMessage());
            System.out.println(e.getMessage());
            return "redirect:" + Routes.UPLOAD;
        }

        attributes.addFlashAttribute("message", "Upload von " + fileName + " erfolgreich");

        return "redirect:" + Routes.UPLOAD;
    }
}
