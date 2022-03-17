package de.denktmit.tam.business.service.impl;

import de.denktmit.tam.persistence.model.WorkRecordEntity;
import de.denktmit.tam.persistence.repository.WorkRecordRepository;
import de.denktmit.tam.business.service.WorkRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkRecordServiceImpl implements WorkRecordService {
    private WorkRecordRepository workRecordRepository;

    @Autowired
    public WorkRecordServiceImpl(WorkRecordRepository workRecordRepository) {
        this.workRecordRepository = workRecordRepository;
    }

    @Override
    public boolean existsById(Long workRecordId) {
        return workRecordRepository.findById(workRecordId).isPresent();
    }

    @Override
    public Optional<WorkRecordEntity> findById(Long workRecordId) {
        return workRecordRepository.findById(workRecordId);
    }

    @Override
    public List<WorkRecordEntity> findAllByOrderByIdAsc() {
        return workRecordRepository.findAllByOrderByIdAsc();
    }
}
