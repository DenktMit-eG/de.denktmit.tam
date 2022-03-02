package de.denktmit.tam.webapp.model.business;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "time_sheet_record")
@NaturalIdCache
@Getter
@Setter
public class TimeSheetRecordEntity extends Auditable<String> {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Id
    @Column(name = "id")
    private Long id;
   
    @JoinColumn(name = "work_record_id")
    @ManyToOne
    @NotNull
    @NaturalId
    private final WorkRecordEntity workRecord;
   
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

    @Column(name = "rate_per_hour")
    @NotNull
    @DecimalMin(value = "0", inclusive = true)
    private BigDecimal ratePerHour;

    private TimeSheetRecordEntity() {
        this.workRecord = null;
        this.position = null;
    }

    public TimeSheetRecordEntity(WorkRecordEntity workRecord, Short position) {
        this.workRecord = workRecord;
        this.position = position;
    }

    public TimeSheetRecordEntity(WorkRecordEntity workRecord, Short position, LocalDate date, Instant begin, Instant end,
                                 String description, int durationInMinutes, BigDecimal ratePerHour) {
        this.workRecord = workRecord;
        this.position = position;
        this.date = date;
        this.beginning = begin;
        this.ending = end;
        this.description = description;
        this.durationInMinutes = durationInMinutes;
        this.ratePerHour = ratePerHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeSheetRecordEntity)) return false;
        TimeSheetRecordEntity that = (TimeSheetRecordEntity) o;
        return Objects.equals(workRecord, that.workRecord) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workRecord, position);
    }
}
