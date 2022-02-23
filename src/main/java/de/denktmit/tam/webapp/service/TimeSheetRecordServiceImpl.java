package de.denktmit.tam.webapp.service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import de.denktmit.tam.webapp.model.business.TimeSheetRecordEntity;
import de.denktmit.tam.webapp.model.business.WorkRecordEntity;
import de.denktmit.tam.webapp.persistence.TimeSheetRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("timeSheetRecordServiceImpl")
public class TimeSheetRecordServiceImpl implements TimeSheetRecordService{

    private TimeSheetRecordRepository timeSheetRecordRepository;

    @Autowired
    public TimeSheetRecordServiceImpl(TimeSheetRecordRepository timeSheetRecordRepository) {
        this.timeSheetRecordRepository = timeSheetRecordRepository;
    }

    public TimeSheetRecordEntity save(TimeSheetRecordEntity timeSheetRecordEntity) {
        return timeSheetRecordRepository.save(timeSheetRecordEntity);
    }

    @Transactional
    public List<TimeSheetRecordEntity> saveAll(List<TimeSheetRecordEntity> timeSheetRecordEntityList) {
        List<TimeSheetRecordEntity> result = new ArrayList<>();

        for (TimeSheetRecordEntity entity : timeSheetRecordEntityList) {
            result.add(timeSheetRecordRepository.save(entity));
        }

        return result;
    }

    @Transactional
    @Override
    public Long deleteByWorkRecordId(Long workRecordId) {
        return timeSheetRecordRepository.deleteByWorkRecordId(workRecordId);
    }

    @Override
    public List<TimeSheetRecordEntity> convertFilestreamToTimeSheetRecordEntities(InputStream inputStream, Long workRecordId)
            throws IOException, IllegalArgumentException {

        ArrayList<TimeSheetRecordEntity> timeSheetRecordEntities = new ArrayList<>();
        CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(inputStream))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build();

        if (Arrays.compare(CSVRecordHeader.DEFAULT_HEADER, csvReader.readNext()) != 0) {
            throw new IllegalArgumentException(
                    "Ihre Kopfzeilen sind nicht korrekt organisiert. Bitte nutzen Sie die Vorlage des Systems " +
                            "für CSV-Uploads.");
        }

        String[] nextRecord;
        while ((nextRecord = csvReader.readNext()) != null) {
            try {
                timeSheetRecordEntities.add(TimeSheetRecordMapper.mapCsvRecordToTimeSheetRecord(workRecordId, nextRecord));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(
                        "Zeile " + csvReader.getLinesRead() + " kann nicht verarbeitet werden. Bitte prüfen Sie ihre "
                                + "Eingaben." + e.getMessage());
            }
        }

        return timeSheetRecordEntities;
    }
}
