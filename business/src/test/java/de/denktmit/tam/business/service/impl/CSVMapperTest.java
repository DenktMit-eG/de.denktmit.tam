package de.denktmit.tam.business.service.impl;

import de.denktmit.tam.persistence.model.ContractEntity;
import de.denktmit.tam.persistence.model.TimeSheetRecordEntity;
import de.denktmit.tam.persistence.model.WorkRecordEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CSVMapperTest {

    @Test
    void mapCsvRecordToTimeSheetRecordTest() {
        String position = "1";

        String dateString = "15.03.2022";
        LocalDate date = LocalDate.parse(dateString, LocalTimeFormatters.DATE_FORMATTER);

        String beginTimeString = "11:00";
        Instant beginTime = Instant.parse(date.toString() + "T" + beginTimeString + ":00Z");

        String endTimeString = "11:15";
        Instant endTime = Instant.parse(date.toString() + "T" + endTimeString + ":00Z");

        String durationString = "15";
        int duration = Integer.parseInt(durationString);

        String rateString = "130";
        BigDecimal rate = new BigDecimal(rateString);

        String description = "Unit Testing";

        String[] record = {position, dateString, beginTimeString, endTimeString, durationString, rateString, description};

        WorkRecordEntity workRecordEntity = new WorkRecordEntity(new ContractEntity("1"),
                Short.parseShort("2022"), Short.parseShort("3"), Instant.now());

        TimeSheetRecordEntity mappingResult = CSVMapper.mapTimeSheetRecord(workRecordEntity,
                record);

        assertEquals(position, mappingResult.getPosition().toString());
        assertEquals(date, mappingResult.getDate());
        assertEquals(beginTime, mappingResult.getBeginning());
        assertEquals(endTime, mappingResult.getEnding());
        assertEquals(duration, mappingResult.getDurationInMinutes());
        assertEquals(rate, mappingResult.getRatePerHour());
        assertEquals(description, mappingResult.getDescription());
        assertEquals(workRecordEntity, mappingResult.getWorkRecord());
    }
}
