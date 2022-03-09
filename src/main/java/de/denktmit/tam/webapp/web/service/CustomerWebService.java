package de.denktmit.tam.webapp.web.service;

import de.denktmit.tam.webapp.model.business.CustomerEntity;
import de.denktmit.tam.webapp.web.model.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerWebService {
    CustomerEntity createCustomer(CustomerDTO customerDTO);

    CustomerEntity updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long id);

    List<CustomerDTO> getCustomersPageable();

    Page<CustomerDTO> getCustomersPageable(Pageable pageable);
}
