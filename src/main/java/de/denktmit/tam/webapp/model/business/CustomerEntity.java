package de.denktmit.tam.webapp.model.business;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "customer")
@NaturalIdCache
@Getter
@Setter
public class CustomerEntity extends Auditable<String> {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Id
    @Column(name = "id")
    private Long id;
   
    @Column(name = "company_name")
    @NotBlank
    @NaturalId
    private final String companyName;
   
    @Column(name = "contact_name")
    @NotBlank
    private String contactName;
   
    @Column(name = "address_country_iso_code")
    @NotBlank
    private String addressCountryIsoCode;
   
    @Column(name = "address_zip")
    @NotBlank
    private String addressZip;
   
    @Column(name = "address_city")
    @NotBlank
    private String addressCity;
   
    @Column(name = "address_street")
    @NotBlank
    private String addressStreet;

    private String createdBy;

    private CustomerEntity() {
        this.companyName = null;
    }

    public CustomerEntity(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerEntity)) return false;
        CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(companyName, that.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName);
    }
}
