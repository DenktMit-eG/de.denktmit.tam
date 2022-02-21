package de.denktmit.tam.webapp.model.business;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "time_sheet_record")
@NaturalIdCache
public class TimeSheetRecordEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Id
    @Column(name = "id")
    private Long id;
   
    @Column(name = "work_record_id")
    @NotNull
    @NaturalId
    private final Long workRecordId;
   
    @Column(name = "position")
    @NotNull
    @NaturalId
    private final Short position;

    @Column(name = "date")
    @NotNull
    private LocalDate date;
   
    @Column(name = "beginning")
    @NotNull
    private Instant beginning;
   
    @Column(name = "ending")
    @NotNull
    // type 'java.time.Instant' + custom validator: end > begin
    private Instant ending;
   
    @Column(name = "description")
    @NotBlank
    private String description;
   
    @Column(name = "duration_in_minutes")
    @NotNull
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

    public TimeSheetRecordEntity(Long workRecordId, Short position, LocalDate date, Instant begin, Instant end,
                                 String description, int durationInMinutes) {
        this.workRecordId = workRecordId;
        this.position = position;
        this.date = date;
        this.beginning = begin;
        this.ending = end;
        this.description = description;
        this.durationInMinutes = durationInMinutes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWorkRecordId() {
        return workRecordId;
    }

    public Short getPosition() {
        return position;
    }

    public Instant getBeginning() {
        return beginning;
    }

    public void setBeginning(Instant begin) {
        this.beginning = begin;
    }

    public Instant getEnding() {
        return ending;
    }

    public void setEnding(Instant end) {
        this.ending = end;
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
