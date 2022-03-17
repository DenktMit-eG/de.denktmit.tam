package de.denktmit.tam.persistence.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "cost_centre")
@NaturalIdCache
@Getter
@Setter
public class CostCentreEntity extends Auditable<String> {
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
