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
    private long id;

    @Column(name = "code")
    @NotBlank
    @NaturalId
    private final String code;
   
    @Column(name = "fk_cost_centre_id")
    @NotBlank
    private long fkCostCentreId;
   
    @Column(name = "fk_project_id")
    @NotBlank
    private long fkProjectId;
   
    @Column(name = "fk_contractor_id")
    @NotBlank
    private long fkContractorId;
   
    @Column(name = "rate_per_hour")
    @NotBlank
    @DecimalMin(value = "0", inclusive = false)
    private BigDecimal ratePerHour;

    private ContractEntity() {
        code = null;
    }

    public ContractEntity(String code) {
        this.code = Objects.requireNonNull(code);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public long getFkCostCentreId() {
        return fkCostCentreId;
    }

    public void setFkCostCentreId(long fkCostCentreId) {
        this.fkCostCentreId = fkCostCentreId;
    }

    public long getFkProjectId() {
        return fkProjectId;
    }

    public void setFkProjectId(long fkProjectId) {
        this.fkProjectId = fkProjectId;
    }

    public long getFkContractorId() {
        return fkContractorId;
    }

    public void setFkContractorId(long fkContractorId) {
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
