package de.denktmit.tam.webapp.model.business;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "work_record")
public class WorkRecordEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Id
    @Column(name = "id")
    private long id;
   
    @Column(name = "fk_contract_id")
    @NotBlank
    private final Long fkContractId;

    @Column(name = "billing_year")
    @NotBlank
    @DecimalMin(value = "2020")
    private final Short billingYear;

    @DecimalMin(value = "1")
    @DecimalMax(value = "12")
    @Column(name = "billing_month")
    @NotBlank
    private final Short billingMonth;

    @Column(name = "upload_date")
    @NotBlank
    private final Instant uploadDate;

    @Column(name = "work_record_upload_id")
    @NotBlank
    private int workRecordUploadId; //TODO: rename fk_

    @Column(name = "credit_note_id")
    private Integer creditNoteId; //TODO: rename fk_

    @Column(name = "invoice_id")
    private Integer invoiceId; //TODO: rename fk_

    private WorkRecordEntity() {
        this.fkContractId = null;
        this.billingYear = null;
        this.billingMonth = null;
        this.uploadDate = null;
    }

    public WorkRecordEntity(Long fkContractId, short billingYear, short billingMonth, Instant uploadDate) {
        this.fkContractId = fkContractId;
        this.billingYear = billingYear;
        this.billingMonth = billingMonth;
        this.uploadDate = uploadDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFkContractId() {
        return fkContractId;
    }

    public short getBillingYear() {
        return billingYear;
    }


    public short getBillingMonth() {
        return billingMonth;
    }


    public Instant getUploadDate() {
        return uploadDate;
    }

    public int getWorkRecordUploadId() {
        return workRecordUploadId;
    }

    public void setWorkRecordUploadId(int workRecordUploadId) {
        this.workRecordUploadId = workRecordUploadId;
    }

    public Integer getCreditNoteId() {
        return creditNoteId;
    }

    public void setCreditNoteId(Integer creditNoteId) {
        this.creditNoteId = creditNoteId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkRecordEntity)) return false;
        WorkRecordEntity that = (WorkRecordEntity) o;
        return Objects.equals(fkContractId, that.fkContractId) && Objects.equals(billingYear, that.billingYear) && Objects.equals(billingMonth, that.billingMonth) && Objects.equals(uploadDate, that.uploadDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkContractId, billingYear, billingMonth, uploadDate);
    }
}
