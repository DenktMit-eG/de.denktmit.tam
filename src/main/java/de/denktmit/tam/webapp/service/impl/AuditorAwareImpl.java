package de.denktmit.tam.webapp.service.impl;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<String> usernameOptional = Optional.ofNullable(username);
        return usernameOptional;
    }
}
