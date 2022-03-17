package de.denktmit.tam.web.mapper;

import de.denktmit.tam.persistence.model.WorkRecordEntity;
import de.denktmit.tam.web.model.WorkRecordDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;

@Mapper(componentModel = "spring")
@Repository
public interface WorkRecordMapper {

    WorkRecordMapper INSTANCE = Mappers.getMapper(WorkRecordMapper.class);

    WorkRecordDTO toWorkRecordDto(WorkRecordEntity workRecordEntity);

    WorkRecordEntity fromDTO(WorkRecordDTO workRecordDTO);

    List<WorkRecordDTO> toDTOs(List<WorkRecordEntity> workRecordEntities);

    default Page<WorkRecordDTO> toPageDTOs(Page<WorkRecordEntity> workRecordEntitiesPage) {
        return workRecordEntitiesPage.map(this::toWorkRecordDto);
    }

    default LocalDate mapDate(Instant instant) {
        return instant.atZone(ZoneOffset.UTC).toLocalDate();
    }

    default LocalTime mapTime(Instant instant) {
        return instant.atZone(ZoneOffset.UTC).toLocalTime();
    }
}
