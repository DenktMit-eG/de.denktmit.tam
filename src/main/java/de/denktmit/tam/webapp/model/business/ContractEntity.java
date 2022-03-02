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
import java.util.Objects;

@Entity
@Table(name = "contract")
@NaturalIdCache
@Getter
@Setter
public class ContractEntity extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    @NotBlank
    @NaturalId
    private final String code;
   
    @JoinColumn(name = "fk_cost_centre_id")
    @ManyToOne
    @NotNull
    private CostCentreEntity costCentre;
   
    @JoinColumn(name = "fk_project_id")
    @ManyToOne
    @NotNull
    private ProjectEntity project;
   
    @JoinColumn(name = "fk_contractor_id")
    @ManyToOne
    @NotNull
    private UserEntity contractor;

    private ContractEntity() {
        code = null;
    }

    public ContractEntity(String code) {
        this.code = Objects.requireNonNull(code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContractEntity)) return false;
        ContractEntity that = (ContractEntity) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
