package de.denktmit.tam.web.mapper;

import de.denktmit.tam.persistence.model.ContractEntity;
import de.denktmit.tam.persistence.model.WorkRecordEntity;
import de.denktmit.tam.web.model.WorkRecordDTO;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
public class WorkRecordMapperImpl implements WorkRecordMapper {

    @Override
    public WorkRecordDTO toWorkRecordDto(WorkRecordEntity workRecordEntity) {
        if ( workRecordEntity == null ) {
            return null;
        }

        WorkRecordDTO workRecordDTO = new WorkRecordDTO();

        workRecordDTO.setId( workRecordEntity.getId() );
        workRecordDTO.setBillingYear( workRecordEntity.getBillingYear() );
        workRecordDTO.setBillingMonth( workRecordEntity.getBillingMonth() );
        workRecordDTO.setUploadDate( workRecordEntity.getUploadDate() );
        workRecordDTO.setTimeSheet( workRecordEntity.getTimeSheet() );
        workRecordDTO.setCreditNote( workRecordEntity.getCreditNote() );
        workRecordDTO.setInvoice( workRecordEntity.getInvoice() );

        return workRecordDTO;
    }

    @Override
    public WorkRecordEntity fromDTO(WorkRecordDTO workRecordDTO) {
        if ( workRecordDTO == null ) {
            return null;
        }

        Short billingYear = null;
        Short billingMonth = null;
        Instant uploadDate = null;

        billingYear = workRecordDTO.getBillingYear();
        billingMonth = workRecordDTO.getBillingMonth();
        uploadDate = workRecordDTO.getUploadDate();

        ContractEntity contract = null;

        WorkRecordEntity workRecordEntity = new WorkRecordEntity( contract, billingYear, billingMonth, uploadDate );

        workRecordEntity.setId( workRecordDTO.getId() );
        workRecordEntity.setTimeSheet( workRecordDTO.getTimeSheet() );
        workRecordEntity.setCreditNote( workRecordDTO.getCreditNote() );
        workRecordEntity.setInvoice( workRecordDTO.getInvoice() );

        return workRecordEntity;
    }

    @Override
    public List<WorkRecordDTO> toDTOs(List<WorkRecordEntity> workRecordEntities) {
        if ( workRecordEntities == null ) {
            return null;
        }

        List<WorkRecordDTO> list = new ArrayList<WorkRecordDTO>( workRecordEntities.size() );
        for ( WorkRecordEntity workRecordEntity : workRecordEntities ) {
            list.add( toWorkRecordDto( workRecordEntity ) );
        }

        return list;
    }
}
