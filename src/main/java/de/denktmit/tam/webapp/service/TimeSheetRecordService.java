package de.denktmit.tam.webapp.service;

import de.denktmit.tam.webapp.model.business.TimeSheetRecordEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public interface TimeSheetRecordService {
    TimeSheetRecordEntity save(TimeSheetRecordEntity timeSheetRecordEntity);

    List<TimeSheetRecordEntity> saveAll(List<TimeSheetRecordEntity> timeSheetRecordEntityList);

    Long deleteByWorkRecordId(Long workRecordId);

    List<TimeSheetRecordEntity> convertFilestreamToTimeSheetRecordEntities(InputStream inputStream,
                                                                           Long workRecordId) throws IOException;
}
