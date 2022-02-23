package de.denktmit.tam.webapp.service;

public record CSVRecordHeader() {

    static String[] DEFAULT_HEADER = {"position", "date", "begin", "end", "durationInMinutes", "description"};

}
