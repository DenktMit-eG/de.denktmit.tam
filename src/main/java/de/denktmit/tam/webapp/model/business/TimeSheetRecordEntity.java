package de.denktmit.tam.webapp.model.business;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "time_sheet_record")
public class TimeSheetRecordEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Id
    @Column(name = "id")
    private long id;
   
    @Column(name = "work_record_id")
    @NotBlank
    private final Long workRecordId;
   
    @Column(name = "position")
    @NotBlank
    private final Short position;
   
    @Column(name = "begin")
    @NotBlank
    private Instant begin;
   
    @Column(name = "end")
    @NotBlank //TODO: custom validator: end > begin
    private Instant end;
   
    @Column(name = "description")
    @NotBlank
    private String description;
   
    @Column(name = "duration_in_minutes")
    @NotBlank
    @DecimalMin(value = "0", inclusive = false)
    private int durationInMinutes;

    private TimeSheetRecordEntity() {
        this.workRecordId = null;
        this.position = null;
    }

    public TimeSheetRecordEntity(Long workRecordId, Short position) {
        this.workRecordId = workRecordId;
        this.position = position;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getWorkRecordId() {
        return workRecordId;
    }

    public short getPosition() {
        return position;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeSheetRecordEntity)) return false;
        TimeSheetRecordEntity that = (TimeSheetRecordEntity) o;
        return Objects.equals(workRecordId, that.workRecordId) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workRecordId, position);
    }
}
