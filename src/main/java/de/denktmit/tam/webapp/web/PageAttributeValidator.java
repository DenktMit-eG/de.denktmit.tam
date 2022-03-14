package de.denktmit.tam.webapp.web;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PageAttributeValidator {
    private static final int DEFAULT_PAGE_NUMBER = 1;

    public static int checkPageId(Optional<Integer> page) {
        if (page.isEmpty()) {
            return DEFAULT_PAGE_NUMBER;
        } else if (page.get().intValue() < 1) {
            return DEFAULT_PAGE_NUMBER;
        } else {
            return page.get().intValue();
        }
    }
}
