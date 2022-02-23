package de.denktmit.tam.webapp.web;

import de.denktmit.tam.webapp.model.business.WorkRecordEntity;
import de.denktmit.tam.webapp.persistence.WorkRecordRepository;
import de.denktmit.tam.webapp.service.TimeSheetDocumentService;
import de.denktmit.tam.webapp.service.TimeSheetMarshallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.Optional;

@Controller
public class UploadRestController {
    final TimeSheetMarshallService timeSheetMarshallService;
    final WorkRecordRepository workRecordRepository;
    final TimeSheetDocumentService timeSheetDocumentService;

    @Autowired
    public UploadRestController(TimeSheetMarshallService timeSheetMarshallService,
                                WorkRecordRepository workRecordRepository,
                                TimeSheetDocumentService timeSheetDocumentService) {
        this.timeSheetMarshallService = timeSheetMarshallService;
        this.workRecordRepository = workRecordRepository;
        this.timeSheetDocumentService = timeSheetDocumentService;
    }

    @PostMapping(Routes.REST_UPLOAD)
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("workRecordId") String workRecordId,
                             RedirectAttributes attributes) {

        // check if file is empty
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Bitte wähle zuerst deine Datei aus");
            return "redirect:" + Routes.UPLOAD;
        }

        // normalize the file path
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        // save the file on the local file system
        try {
            String UPLOAD_DIR = Directories.UPLOADS;
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            attributes.addFlashAttribute("message",
                    "Beim Upload von " + fileName + " ist ein Fehler aufgetreten. ");
            System.out.println(e.getMessage());
            return "redirect:" + Routes.UPLOAD;
        }

        Optional<WorkRecordEntity> workRecord = workRecordRepository.findById(Long.parseLong(workRecordId));
        if(workRecord.isEmpty()){
            attributes.addFlashAttribute("message", "Beim Upload von " + fileName +
                    " ist ein Fehler aufgetreten. Die Zeitnachweis ID für Ihren Upload ist dem System nicht bekannt");
            System.out.println("WorkRecord is empty");
            return "redirect:" + Routes.UPLOAD;
        }

        try {
            timeSheetMarshallService.createAndPersistTimeSheetFromCSV(file.getInputStream(), workRecord.get());
            timeSheetDocumentService.createTimeSheetDocument("Timesheet", fileName,
                    file.getInputStream().readAllBytes(), "username");
        } catch (IOException | IllegalArgumentException e) {
            attributes.addFlashAttribute("message", "Beim Upload von " + fileName +
                    " ist ein Fehler aufgetreten. " + e.getMessage());
            System.out.println(e.getMessage());
            return "redirect:" + Routes.UPLOAD;
        }

        // return success response
        attributes.addFlashAttribute("message", "Upload von " + fileName + " erfolgreich");

        return "redirect:" + Routes.UPLOAD;
    }
}
