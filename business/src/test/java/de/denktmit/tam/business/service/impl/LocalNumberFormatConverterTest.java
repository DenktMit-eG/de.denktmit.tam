package de.denktmit.tam.business.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalNumberFormatConverterTest {

    @Test
    void convertNumberStringFromDEtoUSDecimalTest() {
        String germanNumberFormatString = "13,37";
        String usNumberFormatString = "13.37";

        String convertetNumberString =
                LocalNumberFormatConverter.converFromDEtoUSFormat(germanNumberFormatString);
        assertEquals(usNumberFormatString, convertetNumberString);
    }

    @Test
    void convertNumberStringFromDEtoUSThousandsTest() {
        String germanNumberFormatString = "1.337,99";
        String usNumberFormatString = "1337.99";

        String convertetNumberString =
                LocalNumberFormatConverter.converFromDEtoUSFormat(germanNumberFormatString);
        assertEquals(usNumberFormatString, convertetNumberString);
    }

    @Test
    void convertNumberStringFromDEtoUSMillionsTest() {
        String germanNumberFormatString = "1.337.133,70";
        String usNumberFormatString = "1337133.70";

        String convertetNumberString =
                LocalNumberFormatConverter.converFromDEtoUSFormat(germanNumberFormatString);
        assertEquals(usNumberFormatString, convertetNumberString);
    }

    @Test
    void convertNumberStringFromDEtoUSMillionsWtihoutSeparatorTest() {
        String germanNumberFormatString = "1337133,70";
        String usNumberFormatString = "1337133.70";

        String convertetNumberString =
                LocalNumberFormatConverter.converFromDEtoUSFormat(germanNumberFormatString);
        assertEquals(usNumberFormatString, convertetNumberString);
    }

    @Test
    void convertNumberStringFromDEtoUSMillionsSingleDigitTest() {
        String germanNumberFormatString = "0";
        String usNumberFormatString = "0";

        String convertetNumberString =
                LocalNumberFormatConverter.converFromDEtoUSFormat(germanNumberFormatString);
        assertEquals(usNumberFormatString, convertetNumberString);
    }

    @Test
    void convertNumberStringFromDEtoUSNegativeNumbersTest() {
        String germanNumberFormatString = "-99,00";
        String usNumberFormatString = "-99.00";

        String convertetNumberString =
                LocalNumberFormatConverter.converFromDEtoUSFormat(germanNumberFormatString);
        assertEquals(usNumberFormatString, convertetNumberString);
    }

    @Test
    void convertNumberStringFromDEtoUSNegativeMillionNumbersTest() {
        String germanNumberFormatString = "-9.999.999,00";
        String usNumberFormatString = "-9999999.00";

        String convertetNumberString =
                LocalNumberFormatConverter.converFromDEtoUSFormat(germanNumberFormatString);
        assertEquals(usNumberFormatString, convertetNumberString);
    }
}
