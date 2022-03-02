package de.denktmit.tam.webapp.web.mapper;

import de.denktmit.tam.webapp.model.business.CustomerEntity;
import de.denktmit.tam.webapp.web.model.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO toDTO(CustomerEntity customerEntity);

    CustomerEntity fromDTO(CustomerDTO customerDTO);

    List<CustomerDTO> toDTOs(List<CustomerEntity> customerEntities);
}
