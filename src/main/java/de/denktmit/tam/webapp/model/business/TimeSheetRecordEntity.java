package de.denktmit.tam.webapp.model.business;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "time_sheet_record", schema = "public", catalog = "postgres")
public class TimeSheetRecordEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
   
    @Column(name = "work_record_id")
    private long workRecordId;
   
    @Column(name = "position")
    private short position;
   
    @Column(name = "begin")
    private Object begin;
   
    @Column(name = "end")
    private Object end;
   
    @Column(name = "description")
    private String description;
   
    @Column(name = "duration_in_minutes")
    private int durationInMinutes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getWorkRecordId() {
        return workRecordId;
    }

    public void setWorkRecordId(long workRecordId) {
        this.workRecordId = workRecordId;
    }

    public short getPosition() {
        return position;
    }

    public void setPosition(short position) {
        this.position = position;
    }

    public Object getBegin() {
        return begin;
    }

    public void setBegin(Object begin) {
        this.begin = begin;
    }

    public Object getEnd() {
        return end;
    }

    public void setEnd(Object end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

}
