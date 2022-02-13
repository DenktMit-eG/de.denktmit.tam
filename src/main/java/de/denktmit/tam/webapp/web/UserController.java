package de.denktmit.tam.webapp.web;

import de.denktmit.tam.webapp.persistence.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
