package de.denktmit.tam.webapp.model.business;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "customer")
@NaturalIdCache
public class CustomerEntity {
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
   
    @Column(name = "adress_country_iso_code")
    @NotBlank
    private String adressCountryIsoCode;
   
    @Column(name = "adress_zip")
    @NotBlank
    private String adressZip;
   
    @Column(name = "adress_city")
    @NotBlank
    private String adressCity;
   
    @Column(name = "adress_street")
    @NotBlank
    private String adressStreet;

    private CustomerEntity() {
        this.companyName = null;
    }

    public CustomerEntity(String companyName) {
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAdressCountryIsoCode() {
        return adressCountryIsoCode;
    }

    public void setAdressCountryIsoCode(String adressCountryIsoCode) {
        this.adressCountryIsoCode = adressCountryIsoCode;
    }

    public String getAdressZip() {
        return adressZip;
    }

    public void setAdressZip(String adressZip) {
        this.adressZip = adressZip;
    }

    public String getAdressCity() {
        return adressCity;
    }

    public void setAdressCity(String adressCity) {
        this.adressCity = adressCity;
    }

    public String getAdressStreet() {
        return adressStreet;
    }

    public void setAdressStreet(String adressStreet) {
        this.adressStreet = adressStreet;
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
