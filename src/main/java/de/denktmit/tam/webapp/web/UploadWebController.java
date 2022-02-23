package de.denktmit.tam.webapp.web;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UploadWebController {

    @GetMapping(Routes.UPLOAD)
    public Model upload(Model model, Authentication auth) {
        //ModelAndView modelAndView = new ModelAndView();
        //model.addAttribute("message", "Bitte wähle zuerst deine Datei aus");
        model.addAttribute("uploadRestURL","/rest/upload?workRecordId=1");
        return model;
    }
}
