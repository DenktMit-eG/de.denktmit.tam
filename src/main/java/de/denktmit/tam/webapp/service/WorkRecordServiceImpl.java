package de.denktmit.tam.webapp.service;

import de.denktmit.tam.webapp.model.business.WorkRecordEntity;
import de.denktmit.tam.webapp.persistence.WorkRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkRecordServiceImpl implements WorkRecordService{
    private WorkRecordRepository workRecordRepository;

    @Autowired
    public WorkRecordServiceImpl(WorkRecordRepository workRecordRepository) {
        this.workRecordRepository = workRecordRepository;
    }

    @Override
    public Optional<WorkRecordEntity> findById(Long workRecordId) {
        return workRecordRepository.findById(workRecordId);
    }
}
