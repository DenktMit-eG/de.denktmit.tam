package de.denktmit.tam.web.service;

import de.denktmit.tam.persistence.model.CustomerEntity;
import de.denktmit.tam.web.model.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerWebService {
    CustomerEntity createCustomer(CustomerDTO customerDTO);

    CustomerEntity updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long id);

    List<CustomerDTO> getCustomers();

    Page<CustomerDTO> getCustomersPageable(Pageable pageable);
}
