package de.denktmit.tam.webapp.model.business;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class CustomerEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Id
    @Column(name = "id")
    private long id;
   
    @Column(name = "company_name")
    private String companyName;
   
    @Column(name = "contact_name")
    private String contactName;
   
    @Column(name = "adress_country_iso_code")
    private String adressCountryIsoCode;
   
    @Column(name = "adress_zip")
    private String adressZip;
   
    @Column(name = "adress_city")
    private String adressCity;
   
    @Column(name = "adress_street")
    private String adressStreet;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

}
