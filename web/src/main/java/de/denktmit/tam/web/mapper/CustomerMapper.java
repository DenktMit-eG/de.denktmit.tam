package de.denktmit.tam.web.mapper;

import de.denktmit.tam.persistence.model.CustomerEntity;
import de.denktmit.tam.web.model.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Mapper(componentModel = "spring")
@Repository
public interface CustomerMapper {
    //CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO toDTO(CustomerEntity customerEntity);

    CustomerEntity fromDTO(CustomerDTO customerDTO);

    default List<CustomerDTO> toDTOs(List<CustomerEntity> customerEntities) {
        return customerEntities.stream().map(this::toDTO).toList();
    }

    default Page<CustomerDTO> toPageOfDTOs(Page<CustomerEntity> customerEntities) {
        return customerEntities.map(this::toDTO);
    }
}
