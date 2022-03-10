package de.denktmit.tam.webapp.service.impl;

import de.denktmit.tam.webapp.model.business.CustomerEntity;
import de.denktmit.tam.webapp.model.business.ProjectEntity;
import de.denktmit.tam.webapp.persistence.CustomerRepository;
import de.denktmit.tam.webapp.persistence.ProjectRepository;
import de.denktmit.tam.webapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ProjectRepository projectRepository) {
        this.customerRepository = customerRepository;
        this.projectRepository = projectRepository;
    }

    @Transactional
    @Override
    public void deleteCustomerById(Long id) throws IllegalArgumentException {
        Optional<CustomerEntity> customer = customerRepository.getById(id);
        if (customer.isEmpty()) {
            throw new IllegalArgumentException("Customer with ID:{" + id + "} does not exist");
        }

        List<ProjectEntity> linkedProjects = projectRepository.findProjectsByCustomer(customer.get());
        if (linkedProjects.size() > 0) {
            throw new IllegalArgumentException("Customer with ID:{" + id + "} has linked projects");
        }

        customerRepository.delete(customer.get());
    }

    @Transactional
    @Override
    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        if (customerEntity.getId() != null && existsCustomerWithId(customerEntity.getId())) {
            throw new IllegalArgumentException(
                    "Customer with PK ID:{" + customerEntity.getId() + "} does already" + " exist");
        }

        if (existsCustomerWithCompanyName(customerEntity.getCompanyName())) {
            throw new IllegalArgumentException("Customer with companyName:{" + customerEntity.getCompanyName()
                    + "} does " + "already" + " exist");
        }

        return customerRepository.save(customerEntity);
    }

    private boolean existsCustomerWithId(Long id) {
        return findCustomerById(id).isPresent();
    }

    private boolean existsCustomerWithCompanyName(String companyName) {
        return findCustomerByCompanyName(companyName).isPresent();
    }

    @Transactional
    @Override
    public CustomerEntity updateCustomer(CustomerEntity customerEntity) {
        Optional<CustomerEntity> customerById = findCustomerById(customerEntity.getId());
        //TODO: dangerous because wrong if we add one field to the entity, is there a generic mapper?
        if (customerById.isPresent()) {
            customerById.get().setContactName(customerEntity.getContactName());
            customerById.get().setAddressCity(customerEntity.getAddressCity());
            customerById.get().setAddressCountryIsoCode(customerEntity.getAddressCountryIsoCode());
            customerById.get().setAddressStreet(customerEntity.getAddressStreet());
            customerById.get().setAddressZip(customerEntity.getAddressZip());
            customerRepository.save(customerById.get());
            return customerById.get();
        } else {
            throw new IllegalArgumentException("Customer can not be updated. It does not exist.");
        }

    }

    @Override
    public Optional<CustomerEntity> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<CustomerEntity> findCustomerByCompanyName(String commpanyName) {
        return customerRepository.getByCompanyName(commpanyName);
    }

    @Override
    public List<CustomerEntity> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<CustomerEntity> findAllCustomers(Sort sort) {
        return customerRepository.findAll(sort);
    }

    @Override
    public Page<CustomerEntity> findAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }
}
