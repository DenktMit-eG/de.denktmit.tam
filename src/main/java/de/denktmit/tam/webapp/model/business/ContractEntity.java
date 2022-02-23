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
public class ContractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    @NotBlank
    @NaturalId
    private final String code;
   
    @Column(name = "fk_cost_centre_id")
    @NotNull
    private Long fkCostCentreId;
   
    @Column(name = "fk_project_id")
    @NotNull
    private Long fkProjectId;
   
    @Column(name = "fk_contractor_id")
    @NotNull
    private Long fkContractorId;

    //TODO: cant do different rates for onsite and remote like without separating contracts
    @Column(name = "rate_per_hour")
    @NotNull
    @DecimalMin(value = "0", inclusive = false)
    private BigDecimal ratePerHour;

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
