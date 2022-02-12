package de.denktmit.tam.webapp.model.business;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cost_centre")
public class CostCentreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
   
    @Column(name = "code")
    private String code;
   
    @Column(name = "name_on_invoice")
    private String nameOnInvoice;
   
    @Column(name = "description")
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameOnInvoice() {
        return nameOnInvoice;
    }

    public void setNameOnInvoice(String nameOnInvoice) {
        this.nameOnInvoice = nameOnInvoice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
