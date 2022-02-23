package de.denktmit.tam.webapp.service;

import java.time.format.DateTimeFormatter;

public record LocalTimeFormatters() {
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
}
