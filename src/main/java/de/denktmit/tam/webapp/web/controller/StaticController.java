package de.denktmit.tam.webapp.web.controller;

import de.denktmit.tam.webapp.web.Routes;
import org.springframework.web.bind.annotation.GetMapping;

public class StaticController {

    @GetMapping(value = {Routes.HOME, Routes.HOME_INDEX})
    public String homePage() {
        return "index";
    }

}
