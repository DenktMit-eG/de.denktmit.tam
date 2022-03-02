package de.denktmit.tam.webapp.service;

import de.denktmit.tam.webapp.model.business.CustomerEntity;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<CustomerEntity> findAll(Sort sort);
}
