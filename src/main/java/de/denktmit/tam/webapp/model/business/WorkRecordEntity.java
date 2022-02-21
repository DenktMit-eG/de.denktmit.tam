package de.denktmit.tam.webapp.model.business;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "work_record")
@NaturalIdCache
public class WorkRecordEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Id
    @Column(name = "id")
    private Long id;
   
    @Column(name = "fk_contract_id")
    @NotNull
    @NaturalId
    private final Long fkContractId;

    @Column(name = "billing_year")
    @NotNull
    @NaturalId
    @DecimalMin(value = "2020")
    private final Short billingYear;

    @Column(name = "billing_month")
    @NotNull
    @NaturalId
    @DecimalMin(value = "1")
    @DecimalMax(value = "12")
    private final Short billingMonth;

    @Column(name = "upload_date")
    @NotNull
    @NaturalId
    private final Instant uploadDate;

    @Column(name = "fk_time_sheet_id")
    private Long fkTimeSheetId;

    @Column(name = "fk_credit_note_id")
    private Long fkCreditNoteId;

    @Column(name = "fk_invoice_id")
    private Long fkInvoiceId;

    private WorkRecordEntity() {
        this.fkContractId = null;
        this.billingYear = null;
        this.billingMonth = null;
        this.uploadDate = null;
    }

    public WorkRecordEntity(Long fkContractId, Short billingYear, Short billingMonth, Instant uploadDate) {
        this.fkContractId = fkContractId;
        this.billingYear = billingYear;
        this.billingMonth = billingMonth;
        this.uploadDate = uploadDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkContractId() {
        return fkContractId;
    }

    public Short getBillingYear() {
        return billingYear;
    }

    public Short getBillingMonth() {
        return billingMonth;
    }

    public Instant getUploadDate() {
        return uploadDate;
    }

    public Long getFkTimeSheetId() {
        return fkTimeSheetId;
    }

    public void setFkTimeSheetId(Long fkTimeSheetId) {
        this.fkTimeSheetId = fkTimeSheetId;
    }

    public Long getFkCreditNoteId() {
        return fkCreditNoteId;
    }

    public void setFkCreditNoteId(Long creditNoteId) {
        this.fkCreditNoteId = creditNoteId;
    }

    public Long getFkInvoiceId() {
        return fkInvoiceId;
    }

    public void setFkInvoiceId(Long invoiceId) {
        this.fkInvoiceId = invoiceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkRecordEntity)) return false;
        WorkRecordEntity that = (WorkRecordEntity) o;
        return Objects.equals(fkContractId, that.fkContractId) && Objects.equals(billingYear,
                that.billingYear) && Objects.equals(billingMonth, that.billingMonth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkContractId, billingYear, billingMonth);
    }
}
