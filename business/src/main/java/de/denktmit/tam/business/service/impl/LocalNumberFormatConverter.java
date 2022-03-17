package de.denktmit.tam.business.service.impl;

import org.springframework.stereotype.Component;

@Component
public class LocalNumberFormatConverter {

    public static String converFromDEtoUSFormat(String numbersIn) {
        String numbersOut = numbersIn;
        numbersOut = numbersOut.replace(".","");
        numbersOut = numbersOut.replace(",",".");
        return numbersOut;
    }
}
