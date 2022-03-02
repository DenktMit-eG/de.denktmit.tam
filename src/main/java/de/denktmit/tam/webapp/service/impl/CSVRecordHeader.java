package de.denktmit.tam.webapp.service.impl;

public record CSVRecordHeader() {

    static String[] DEFAULT_HEADER = {"position", "date", "begin", "end", "durationInMinutes", "ratePerHour",
            "description"};

}
