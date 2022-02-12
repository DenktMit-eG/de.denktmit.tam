package de.denktmit.tam.webapp.model.business;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
@Table(name = "work_record")
public class WorkRecordEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Id
    @Column(name = "id")
    private long id;
   
    @Column(name = "fk_contract_id")
    private long fkContractId;

    @Column(name = "billing_year")
    @NotBlank
    @DecimalMin(value = "2020")
    private final Short billingYear;

    @DecimalMin(value = "1")
    @DecimalMax(value = "12")
    @Column(name = "billing_month")
    @NotBlank
    private final Short billingMonth;

    //TODO: rename fk_
    //TODO: get Document Object instead of Integer
    @Column(name = "upload_date")
    private Instant uploadDate;

    @Column(name = "work_record_upload_id")
    private int workRecordUploadId;

    //TODO: rename fk_
    //TODO: get Document Object instead of Integer
    @Column(name = "credit_note_id")
    private Integer creditNoteId;

    //TODO: rename fk_
    //TODO: get Document Object instead of Integer
    @Column(name = "invoice_id")
    private Integer invoiceId;

    private WorkRecordEntity() {
        this.billingYear = null;
        this.billingMonth = null;
    }

    public WorkRecordEntity(short billingYear, short billingMonth) {
        this.billingYear = billingYear;
        this.billingMonth = billingMonth;
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

    public void setFkContractId(long fkContractId) {
        this.fkContractId = fkContractId;
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

    public void setUploadDate(Instant uploadDate) {
        this.uploadDate = uploadDate;
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

}
