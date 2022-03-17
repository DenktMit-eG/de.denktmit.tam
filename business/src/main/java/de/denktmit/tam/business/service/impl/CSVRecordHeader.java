package de.denktmit.tam.business.service.impl;

public record CSVRecordHeader() {

    static String[] DEFAULT_HEADER = {"position", "date", "begin", "end", "durationInMinutes", "ratePerHour",
            "description"};

}
