package de.denktmit.tam.webapp.service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import de.denktmit.tam.webapp.model.business.WorkRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

@Service
public class TimeSheetMarshallService {
    private final TimeSheetRecordMapper timeSheetRecordMapper;

    @Autowired
    public TimeSheetMarshallService(TimeSheetRecordMapper timeSheetRecordMapper) {
        this.timeSheetRecordMapper = timeSheetRecordMapper;
    }

    public void createAndPersistTimeSheetFromCSV(InputStream inputStream, WorkRecordEntity workRecordEntity)
            throws IOException, IllegalArgumentException {

        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(inputStream)).withCSVParser(csvParser).build();

        checkCsvHeader(csvReader.readNext());

        String[] nextRecord;
        while ((nextRecord = csvReader.readNext()) != null) {
            try {
                timeSheetRecordMapper.mapCsvRecordToTimeSheetRecord(workRecordEntity.getId(), nextRecord);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(
                        "Zeile " + csvReader.getLinesRead() + " kann nicht verarbeitet werden. Bitte prüfen Sie ihre "
                                + "Eingaben." + e.getMessage());
            }
        }
    }

    private void checkCsvHeader(String[] record) throws IllegalArgumentException {
        switch (Arrays.compare(CSVRecordHeader.DEFAULT_HEADER, record)) {
            case 0:
                break;
            default:
                throw new IllegalArgumentException(
                        "Ihre Kopfzeilen sind nicht korrekt organisiert. Bitte nutzen Sie die Vorlage des Systems " +
                                "für CSV-Uploads.");
        }
    }
}
