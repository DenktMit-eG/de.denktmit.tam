package de.denktmit.tam.webapp.service.impl;

import de.denktmit.tam.webapp.model.business.TimeSheetRecordEntity;
import de.denktmit.tam.webapp.model.business.WorkRecordEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class TimeSheetRecordMapper {

    static TimeSheetRecordEntity mapCsvRecordToTimeSheetRecord(WorkRecordEntity workRecord, String[] record) throws
            IllegalArgumentException {
        short position = Short.parseShort(record[0]);
        LocalDate date = LocalDate.parse((record[1]), LocalTimeFormatters.dateFormatter);
        Instant begin = LocalDateTime.parse((record[1]) + " " + record[2],
                LocalTimeFormatters.dateTimeFormatter).toInstant(ZoneOffset.UTC);
        Instant end = LocalDateTime.parse((record[1]) + " " + record[3],
                LocalTimeFormatters.dateTimeFormatter).toInstant(ZoneOffset.UTC);
        int durationInMinutes = Integer.parseInt(record[4]);
        String ratePerHourWithDecimalDot = LocalNumberFormatConverter.convertNumberStringFromDEtoUS(record[5]);
        BigDecimal ratePerHour = new BigDecimal(ratePerHourWithDecimalDot);
        String description = record[6];

        if (null == date || null == begin || null == end || null == description || description.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return new TimeSheetRecordEntity(workRecord, position, date, begin, end, description, durationInMinutes, ratePerHour);
    }

}
