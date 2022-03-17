package de.denktmit.tam.web.service;

import de.denktmit.tam.persistence.model.WorkRecordEntity;
import de.denktmit.tam.web.model.WorkRecordDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WorkRecordWebService {
    WorkRecordEntity createWorkRecord(WorkRecordDTO workRecordDTO);

    WorkRecordEntity updateWorkRecord(WorkRecordDTO workRecordDTO);

    void deleteWorkRecord(Long id);

    List<WorkRecordDTO> getWorkRecords();

    Page<WorkRecordDTO> getWorkRecordsPageable(Pageable pageable);
}
