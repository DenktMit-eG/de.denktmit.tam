package de.denktmit.tam.webapp.service;

import de.denktmit.tam.webapp.model.business.WorkRecordEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface WorkRecordService {
    boolean existsById(Long workRecordId);
    Optional<WorkRecordEntity> findById(Long workRecordId);
    List<WorkRecordEntity> findAllByOrderByIdAsc();
}
