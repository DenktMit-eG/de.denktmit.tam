package de.denktmit.tam.web.mapper;

import de.denktmit.tam.persistence.model.CustomerEntity;
import de.denktmit.tam.web.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CustomerMapperImpl.class})
class CustomerMapperTest {

    private final Long id = 1L;
    private final String companyName = "Paperstreet Soap Corp.";
    private final String contact = "Tyler Durden";
    private final String city = "New York";
    private final String street = "Paper Street 21";
    private final String zipCode = "12345";
    private final String countryCode = "US";

    @Autowired
    private CustomerMapperImpl mapper;

    @Test
    void toDTO() {
        CustomerEntity customerEntity = new CustomerEntity(id, companyName, contact, countryCode, zipCode, city, street);

        CustomerDTO customerDTO = mapper.toDTO(customerEntity);

        assertEquals(id, customerDTO.getId());
        assertEquals(companyName, customerDTO.getCompanyName());
        assertEquals(contact, customerDTO.getContactName());
        assertEquals(city, customerDTO.getAddressCity());
        assertEquals(street, customerDTO.getAddressStreet());
        assertEquals(zipCode, customerDTO.getAddressZip());
        assertEquals(countryCode, customerDTO.getAddressCountryIsoCode());
    }

    @Test
    void fromDTO() {
        CustomerDTO customerDTO = new CustomerDTO(id, companyName, contact, countryCode, zipCode, city, street);

        CustomerEntity customerEntity = mapper.fromDTO(customerDTO);

        assertEquals(id, customerEntity.getId());
        assertEquals(companyName, customerEntity.getCompanyName());
        assertEquals(contact, customerEntity.getContactName());
        assertEquals(city, customerEntity.getAddressCity());
        assertEquals(street, customerEntity.getAddressStreet());
        assertEquals(zipCode, customerEntity.getAddressZip());
        assertEquals(countryCode, customerEntity.getAddressCountryIsoCode());
    }

    @Test
    void toDTOs() {
        CustomerEntity customerEntity = new CustomerEntity(id, companyName, contact, countryCode, zipCode, city, street);
        List<CustomerEntity> customerEntities = new ArrayList<>();
        customerEntities.add(customerEntity);

        List<CustomerDTO> customerDTOs = mapper.toDTOs(customerEntities);

        assertEquals(id, customerDTOs.get(0).getId());
        assertEquals(companyName, customerDTOs.get(0).getCompanyName());
        assertEquals(contact, customerDTOs.get(0).getContactName());
        assertEquals(city, customerDTOs.get(0).getAddressCity());
        assertEquals(street, customerDTOs.get(0).getAddressStreet());
        assertEquals(zipCode, customerDTOs.get(0).getAddressZip());
        assertEquals(countryCode, customerDTOs.get(0).getAddressCountryIsoCode());
    }

    @Test
    void toPageOfDTOs() {
        CustomerEntity customerEntity = new CustomerEntity(id, companyName, contact, countryCode, zipCode, city, street);
        List<CustomerEntity> customerEntities = new ArrayList<>();
        customerEntities.add(customerEntity);
        Page<CustomerEntity> customerEntitiesPage = new PageImpl<>(customerEntities);

        Page<CustomerDTO> customerDTOPage = mapper.toPageOfDTOs(customerEntitiesPage);
        List<CustomerDTO> customerDTOList = customerDTOPage.get().toList();

        assertEquals(id, customerDTOList.get(0).getId());
        assertEquals(companyName, customerDTOList.get(0).getCompanyName());
        assertEquals(contact, customerDTOList.get(0).getContactName());
        assertEquals(city, customerDTOList.get(0).getAddressCity());
        assertEquals(street, customerDTOList.get(0).getAddressStreet());
        assertEquals(zipCode, customerDTOList.get(0).getAddressZip());
        assertEquals(countryCode, customerDTOList.get(0).getAddressCountryIsoCode());
    }
}
