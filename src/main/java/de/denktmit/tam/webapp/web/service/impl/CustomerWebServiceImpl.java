package de.denktmit.tam.webapp.web.service.impl;

import de.denktmit.tam.webapp.model.business.CustomerEntity;
import de.denktmit.tam.webapp.service.CustomerService;
import de.denktmit.tam.webapp.web.mapper.CustomerMapper;
import de.denktmit.tam.webapp.web.model.CustomerDTO;
import de.denktmit.tam.webapp.web.service.CustomerWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerWebServiceImpl implements CustomerWebService {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerWebServiceImpl(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    public CustomerEntity createCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerToCreate = customerMapper.fromDTO(customerDTO);
        return customerService.createCustomer(customerToCreate);
    }

    public CustomerEntity updateCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerToUpdate = customerMapper.fromDTO(customerDTO);
        return customerService.updateCustomer(customerToUpdate);
    }

    public void deleteCustomer(Long id) {
        customerService.deleteCustomerById(id);
    }

    public List<CustomerDTO> getCustomersPageable() {
        List<CustomerEntity> fetchCustomers = customerService.findAllCustomers();
        return customerMapper.toDTOs(fetchCustomers);
    }

    public Page<CustomerDTO> getCustomersPageable(Pageable pageable) {
        Page<CustomerEntity> fetchCustomers = customerService.findAllCustomers(pageable);
        return customerMapper.toPageOfDTOs(fetchCustomers);
    }
}
