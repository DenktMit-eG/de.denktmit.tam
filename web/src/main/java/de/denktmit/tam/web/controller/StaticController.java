package de.denktmit.tam.web.controller;

import de.denktmit.tam.web.Routes;
import org.springframework.web.bind.annotation.GetMapping;

public class StaticController {

    @GetMapping(value = {Routes.HOME, Routes.HOME_INDEX})
    public String homePage() {
        return "index";
    }

}
