package de.denktmit.tam.webapp.service;

import de.denktmit.tam.webapp.model.business.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {

    void deleteCustomerById(Long id);
    CustomerEntity createCustomer(CustomerEntity customerEntity);
    CustomerEntity updateCustomer(CustomerEntity customerEntity);

    Optional<CustomerEntity> findCustomerById(Long id);
    Optional<CustomerEntity> findCustomerByCompanyName(String companyName);
    List<CustomerEntity> findAllCustomers();
    List<CustomerEntity> findAllCustomers(Sort sort);
    Page<CustomerEntity> findAllCustomers(Pageable pageable);
}
