package de.denktmit.tam.webapp.service.impl;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import de.denktmit.tam.webapp.model.business.TimeSheetRecordEntity;
import de.denktmit.tam.webapp.model.business.WorkRecordEntity;
import de.denktmit.tam.webapp.persistence.TimeSheetRecordRepository;
import de.denktmit.tam.webapp.service.TimeSheetRecordService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TimeSheetRecordServiceImpl implements TimeSheetRecordService {

    private TimeSheetRecordRepository timeSheetRecordRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public TimeSheetRecordServiceImpl(TimeSheetRecordRepository timeSheetRecordRepository) {
        this.timeSheetRecordRepository = timeSheetRecordRepository;
    }

    @Override
    public List<TimeSheetRecordEntity> findAllByWorkRecordId(Long workRecordId) {
        return timeSheetRecordRepository.findAllByWorkRecordId(workRecordId);
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
    public List<TimeSheetRecordEntity> convertFilestreamToTimeSheetRecordEntities(InputStream inputStream,
                                                                                  WorkRecordEntity workRecord) throws
            IOException, IllegalArgumentException, CsvValidationException {

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
                timeSheetRecordEntities.add(TimeSheetRecordMapper.mapCsvRecordToTimeSheetRecord(workRecord, nextRecord));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(
                        "Zeile " + csvReader.getLinesRead() + " kann nicht verarbeitet werden. Bitte prüfen Sie ihre "
                                + "Eingaben." + e.getMessage());
            }
        }

        return timeSheetRecordEntities;
    }

    @Transactional
    @Override
    public List<TimeSheetRecordEntity> replaceByWorkRecordId(Long workRecordId,
                                                             List<TimeSheetRecordEntity> timeSheetRecordList) {
        deleteByWorkRecordId(workRecordId);
        entityManager.flush();
        return saveAll(timeSheetRecordList);
    }
}
