package de.denktmit.tam.webapp.service;

import de.denktmit.tam.webapp.model.business.WorkRecordEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface WorkRecordService {
    Optional<WorkRecordEntity> findById(Long workRecordId);
}
