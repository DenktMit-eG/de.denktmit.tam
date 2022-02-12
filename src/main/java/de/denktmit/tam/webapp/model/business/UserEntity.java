package de.denktmit.tam.webapp.model.business;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
   
    @Column(name = "login_name")
    private String loginName;
   
    @Column(name = "login_password")
    private String loginPassword;
   
    @Column(name = "role")
    private String role;
   
    @Column(name = "company_name")
    private String companyName;
   
    @Column(name = "surname")
    private String surname;
   
    @Column(name = "name")
    private String name;
   
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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
