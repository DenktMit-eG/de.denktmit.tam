package de.denktmit.tam.webapp.service.impl;

import de.denktmit.tam.webapp.model.business.CustomerEntity;
import de.denktmit.tam.webapp.persistence.CustomerRepository;
import de.denktmit.tam.webapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> findAll(Sort sort) {
        return (List<CustomerEntity>) customerRepository.findAll(sort);
    }
}
