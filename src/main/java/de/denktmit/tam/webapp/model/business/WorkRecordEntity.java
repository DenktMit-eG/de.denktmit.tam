package de.denktmit.tam.webapp.model.business;

import javax.persistence.*;
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
    private short billingYear;
   
    @Column(name = "billing_month")
    private short billingMonth;
   
    @Column(name = "upload_date")
    private Instant uploadDate;
   
    @Column(name = "work_record_upload_id")
    private int workRecordUploadId;
   
    @Column(name = "credit_note_id")
    private Integer creditNoteId;
   
    @Column(name = "invoice_id")
    private Integer invoiceId;



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

    public void setBillingYear(short billingYear) {
        this.billingYear = billingYear;
    }

    public short getBillingMonth() {
        return billingMonth;
    }

    public void setBillingMonth(short billingMonth) {
        this.billingMonth = billingMonth;
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
