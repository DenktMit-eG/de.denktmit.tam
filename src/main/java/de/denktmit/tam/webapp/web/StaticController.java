package de.denktmit.tam.webapp.web;

import org.springframework.web.bind.annotation.GetMapping;

public class StaticController {


    @GetMapping(value = {Routes.HOME, Routes.HOME_INDEX})
    public String homePage() {
        return "index";
    }

}
