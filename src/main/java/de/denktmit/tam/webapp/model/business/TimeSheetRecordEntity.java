package de.denktmit.tam.webapp.model.business;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "time_sheet_record")
public class TimeSheetRecordEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Id
    @Column(name = "id")
    private long id;
   
    @Column(name = "work_record_id")
    private long workRecordId;
   
    @Column(name = "position")
    private short position;
   
    @Column(name = "begin")
    private Instant begin;
   
    @Column(name = "end")
    private Instant end;
   
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

    public Instant getBegin() {
        return begin;
    }

    public void setBegin(Instant begin) {
        this.begin = begin;
    }

    public Instant getEnd() {
        return end;
    }

    public void setEnd(Instant end) {
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
