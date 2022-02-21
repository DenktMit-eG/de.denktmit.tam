package de.denktmit.tam.webapp.web;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.RolesAllowed;

@Controller
public class SessionController {

    @GetMapping(value = Routes.ME)
    public ResponseEntity<String> me(Authentication auth) {
        return ResponseEntity.ok(auth.getName());
    }

    @GetMapping(value = "/myself")
    @PreAuthorize("$Da")
    @RolesAllowed("admin")
    public ResponseEntity<String> myself() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        return ResponseEntity.ok(auth.getName());
    }

}
