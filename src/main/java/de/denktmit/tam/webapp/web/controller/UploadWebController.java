package de.denktmit.tam.webapp.web.controller;

import com.opencsv.exceptions.CsvValidationException;
import de.denktmit.tam.webapp.model.business.TimeSheetRecordEntity;
import de.denktmit.tam.webapp.model.business.WorkRecordEntity;
import de.denktmit.tam.webapp.service.FileSystemService;
import de.denktmit.tam.webapp.service.TimeSheetDocumentService;
import de.denktmit.tam.webapp.service.TimeSheetRecordService;
import de.denktmit.tam.webapp.service.WorkRecordService;
import de.denktmit.tam.webapp.web.Routes;
import de.denktmit.tam.webapp.web.formbacking.FileUpload;
import de.denktmit.tam.webapp.web.formbacking.WorkRecordSelection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
@SessionAttributes({"workRecordSelection", "fileUpload"})
public class UploadWebController implements WebMvcConfigurer {

    private final WorkRecordService workRecordService;
    private final FileSystemService fileSystemService;
    private final TimeSheetRecordService timeSheetRecordService;
    final TimeSheetDocumentService timeSheetDocumentService;

    @Autowired
    public UploadWebController(WorkRecordService workRecordService, FileSystemService fileSystemService,
                               TimeSheetRecordService timeSheetRecordService,
                               TimeSheetDocumentService timeSheetDocumentService) {
        this.workRecordService = workRecordService;
        this.fileSystemService = fileSystemService;
        this.timeSheetRecordService = timeSheetRecordService;
        this.timeSheetDocumentService = timeSheetDocumentService;
    }

    @GetMapping(Routes.TIMESHEET_UPLOAD_PART1)
    public ModelAndView getUploadForm(ModelAndView mov) {
        mov.setViewName("timesheetUploadStep1.html");
        mov.addObject("workRecordList", workRecordService.findAllByOrderByIdAsc());
        mov.addObject("workRecordSelection", new WorkRecordSelection());
        return mov;
    }

    @PostMapping(Routes.TIMESHEET_UPLOAD_PART2)
    public ModelAndView checkUploadForm(
            @Valid @ModelAttribute("workRecordSelection") WorkRecordSelection workRecordSelection,
            BindingResult bindingResult) {
        ModelAndView mov = new ModelAndView(); // if mov is method parameter, REST Call directly ends in error page
        // because workRecordSelection is invalid -> where is the connection?
        if (bindingResult.hasErrors()) {
            mov.setViewName("timesheetUploadStep1.html");
            mov.addObject("workRecordSelection", workRecordSelection);
            mov.addObject("workRecordList", workRecordService.findAllByOrderByIdAsc());
            return mov;
        }

        mov.setViewName("timesheetUploadStep2.html");
        mov.addObject("fileUpload", new FileUpload());
        mov.addObject("workRecordSelection", workRecordSelection);
        return mov;
    }

    @PostMapping(Routes.TIMESHEET_UPLOAD_PART3)
    public ModelAndView postCSVFileUpload(
            @Valid @ModelAttribute("workRecordSelection") WorkRecordSelection workRecordSelection,
            @Valid @ModelAttribute("fileUpload") FileUpload fileUpload, BindingResult bindingResult) {

        ModelAndView mov = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mov.setViewName("timesheetUploadStep2.html");
            mov.addObject("fileUpload", new FileUpload());
            return mov;
        }

        mov.setViewName("timesheetUploadStep3.html");
        try {
            Long workRecordId = workRecordSelection.getWorkRecordId();
            if (fileUpload.isSuccesfull()) {
                mov.addObject("records", timeSheetRecordService.findAllByWorkRecordId(workRecordId));
                return mov;
            }
            fileSystemService.saveToUploads(fileUpload.getMultipartFile());
            if (!workRecordService.existsById(workRecordId)) {
                mov.addObject("message",
                        "Beim Upload ist ein Fehler aufgetreten. Die Zeitnachweis ID für Ihren Upload " +
                                "ist dem System nicht bekannt");
                return mov;
            }
            MultipartFile multipartFile = fileUpload.getMultipartFile();
            WorkRecordEntity workRecord = workRecordService.findById(workRecordId).get();
            List<TimeSheetRecordEntity> timeSheetRecordEntities =
                    timeSheetRecordService.convertFilestreamToTimeSheetRecordEntities(multipartFile.getInputStream(),
                            workRecord);

            timeSheetRecordService.replaceByWorkRecordId(workRecordId, timeSheetRecordEntities);
            timeSheetDocumentService.saveNewTimeSheetDocument("Timesheet",
                    StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename())),
                    multipartFile.getInputStream().readAllBytes());
            fileUpload.setSuccesfull(true);
            mov.addObject("records", timeSheetRecordService.findAllByWorkRecordId(workRecordId));
            mov.addObject("message", "Upload erfolgreich");
            return mov;
        } catch (IOException | IllegalArgumentException | CsvValidationException | ConstraintViolationException e) {
            mov.addObject("message", "Beim Upload ist ein Fehler aufgetreten." + e.getMessage());
            return mov;
        }
    }
}
