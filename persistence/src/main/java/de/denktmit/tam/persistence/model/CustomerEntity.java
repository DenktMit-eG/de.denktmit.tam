package de.denktmit.tam.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "customer")
@NaturalIdCache
@Getter
@Setter
@Builder
@AllArgsConstructor
public class CustomerEntity extends Auditable<String> {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Id
    @Column(name = "id")
    private Long id;
   
    @Column(name = "company_name")
    @NotBlank
    @Size(max=200)
    @NaturalId
    private final String companyName;
   
    @Column(name = "contact_name")
    @NotBlank
    @Size(max=200)
    private String contactName;
   
    @Column(name = "address_country_iso_code")
    @NotBlank
    @Size(max=5)
    private String addressCountryIsoCode;
   
    @Column(name = "address_zip")
    @NotBlank
    @Size(max=10)
    private String addressZip;
   
    @Column(name = "address_city")
    @NotBlank
    @Size(max=200)
    private String addressCity;
   
    @Column(name = "address_street")
    @NotBlank
    @Size(max=200)
    private String addressStreet;

    public CustomerEntity() {
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
