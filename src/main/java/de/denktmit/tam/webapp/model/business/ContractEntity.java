package de.denktmit.tam.webapp.model.business;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public Long getFkCostCentreId() {
        return fkCostCentreId;
    }

    public void setFkCostCentreId(Long fkCostCentreId) {
        this.fkCostCentreId = fkCostCentreId;
    }

    public Long getFkProjectId() {
        return fkProjectId;
    }

    public void setFkProjectId(Long fkProjectId) {
        this.fkProjectId = fkProjectId;
    }

    public Long getFkContractorId() {
        return fkContractorId;
    }

    public void setFkContractorId(Long fkContractorId) {
        this.fkContractorId = fkContractorId;
    }

    public BigDecimal getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(BigDecimal ratePerHour) {
        this.ratePerHour = ratePerHour;
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
