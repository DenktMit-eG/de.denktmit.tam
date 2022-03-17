package de.denktmit.tam.web.model;

import de.denktmit.tam.persistence.model.WorkRecordEntity;

import java.util.List;

public class WorkRecordDTOWRapperList {

    private List<WorkRecordEntity> workRecords;

    public void setWorkRecords(List<WorkRecordEntity> workRecords) {
        this.workRecords = workRecords;
    }

    public List<WorkRecordEntity> getWorkRecords() {
        return workRecords;
    }
}
