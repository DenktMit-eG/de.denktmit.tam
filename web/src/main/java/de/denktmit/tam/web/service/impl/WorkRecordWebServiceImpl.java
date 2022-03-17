package de.denktmit.tam.web.service.impl;

import de.denktmit.tam.persistence.model.WorkRecordEntity;
import de.denktmit.tam.web.model.WorkRecordDTO;
import de.denktmit.tam.web.service.WorkRecordWebService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkRecordWebServiceImpl implements WorkRecordWebService {
    @Override
    public WorkRecordEntity createWorkRecord(WorkRecordDTO workRecordDTO) {
        return null;
    }

    @Override
    public WorkRecordEntity updateWorkRecord(WorkRecordDTO workRecordDTO) {
        return null;
    }

    @Override
    public void deleteWorkRecord(Long id) {

    }

    @Override
    public List<WorkRecordDTO> getWorkRecords() {
        return null;
    }

    @Override
    public Page<WorkRecordDTO> getWorkRecordsPageable(Pageable pageable) {
        return null;
    }
}
