package de.denktmit.tam.webapp.service.impl;

import org.springframework.stereotype.Component;

@Component
public class LocalNumberFormatConverter {

    public static String convertNumberStringFromDEtoUS(String numbers) {
        numbers.replace(".","");
        numbers.replace(",",".");
        return numbers;
    }
}
