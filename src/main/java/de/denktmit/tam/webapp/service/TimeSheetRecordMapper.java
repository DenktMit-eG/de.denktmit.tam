package de.denktmit.tam.webapp.service;

import de.denktmit.tam.webapp.model.business.TimeSheetRecordEntity;
import de.denktmit.tam.webapp.persistence.TimeSheetRecordRepository;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Component
public class TimeSheetRecordMapper {
    final TimeSheetRecordRepository timeSheetRecordRepository;


    public TimeSheetRecordMapper(TimeSheetRecordRepository timeSheetRecordRepository) {
        this.timeSheetRecordRepository = timeSheetRecordRepository;
    }

    public TimeSheetRecordEntity mapCsvRecordToTimeSheetRecord(Long workRecordId, String[] record) throws
            IllegalArgumentException {

        Short position = Short.valueOf(record[0]);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse((record[1]), dateFormatter);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime beginAsDateTime = LocalDateTime.parse((record[1]) + " " + record[2], dateTimeFormatter);
        Instant begin = beginAsDateTime.toInstant(ZoneOffset.UTC);

        LocalDateTime endAsDateTime = LocalDateTime.parse((record[1]) + " " + record[3], dateTimeFormatter);
        Instant end = endAsDateTime.toInstant(ZoneOffset.UTC);

        Integer durationInMinutes = Integer.valueOf(record[4]);
        String description = record[5];

        if (null == position || null == date || null == begin || null == end || null == durationInMinutes ||
                null == description || description.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return timeSheetRecordRepository.save(
                new TimeSheetRecordEntity(workRecordId, position, date, begin, end, description, durationInMinutes));

    }
}
