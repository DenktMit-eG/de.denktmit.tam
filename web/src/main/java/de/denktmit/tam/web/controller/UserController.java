package de.denktmit.tam.web.controller;

import de.denktmit.tam.persistence.repository.UserRepository;
import de.denktmit.tam.web.Routes;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping(value = Routes.USERS, produces = MediaType.TEXT_HTML_VALUE)
    public String showAll() {
        return "users";
    }

}
