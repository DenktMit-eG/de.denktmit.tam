package de.denktmit.tam.webapp.model.business;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "cost_centre")
@NaturalIdCache
public class CostCentreEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Id
    @Column(name = "id")
    private Long id;
   
    @Column(name = "code")
    @NotBlank
    @NaturalId
    private final String code;
   
    @Column(name = "name_on_invoice")
    @NotBlank
    private String nameOnInvoice;
   
    @Column(name = "description")
    private String description;

    private CostCentreEntity() {
        this.code = null;
    }

    public CostCentreEntity(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CostCentreEntity)) return false;
        CostCentreEntity that = (CostCentreEntity) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
