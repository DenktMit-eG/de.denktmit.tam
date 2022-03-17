package de.denktmit.tam.web.mapper;

import de.denktmit.tam.persistence.model.CustomerEntity;
import de.denktmit.tam.web.model.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO toDTO(CustomerEntity customerEntity) {
        if (customerEntity == null) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId(customerEntity.getId());
        customerDTO.setCompanyName(customerEntity.getCompanyName());
        customerDTO.setContactName(customerEntity.getContactName());
        customerDTO.setAddressCountryIsoCode(customerEntity.getAddressCountryIsoCode());
        customerDTO.setAddressZip(customerEntity.getAddressZip());
        customerDTO.setAddressCity(customerEntity.getAddressCity());
        customerDTO.setAddressStreet(customerEntity.getAddressStreet());

        return customerDTO;
    }

    @Override
    public CustomerEntity fromDTO(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }

        CustomerEntity.CustomerEntityBuilder customerEntity = CustomerEntity.builder();

        customerEntity.id(customerDTO.getId());
        customerEntity.companyName(customerDTO.getCompanyName());
        customerEntity.contactName(customerDTO.getContactName());
        customerEntity.addressCountryIsoCode(customerDTO.getAddressCountryIsoCode());
        customerEntity.addressZip(customerDTO.getAddressZip());
        customerEntity.addressCity(customerDTO.getAddressCity());
        customerEntity.addressStreet(customerDTO.getAddressStreet());

        return customerEntity.build();
    }
}
