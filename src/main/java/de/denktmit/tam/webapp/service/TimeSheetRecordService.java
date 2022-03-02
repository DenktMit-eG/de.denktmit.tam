package de.denktmit.tam.webapp.service;

import com.opencsv.exceptions.CsvValidationException;
import de.denktmit.tam.webapp.model.business.TimeSheetRecordEntity;
import de.denktmit.tam.webapp.model.business.WorkRecordEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public interface TimeSheetRecordService {
    List<TimeSheetRecordEntity> findAllByWorkRecordId(Long workRecordId);

    TimeSheetRecordEntity save(TimeSheetRecordEntity timeSheetRecordEntity);

    List<TimeSheetRecordEntity> saveAll(List<TimeSheetRecordEntity> timeSheetRecordEntityList);

    Long deleteByWorkRecordId(Long workRecordId);

    List<TimeSheetRecordEntity> convertFilestreamToTimeSheetRecordEntities(InputStream inputStream,
                                                                           WorkRecordEntity workRecord) throws
            IOException, CsvValidationException;

    List<TimeSheetRecordEntity> replaceByWorkRecordId(Long workRecordId, List<TimeSheetRecordEntity> timeSheetRecordList);

}
