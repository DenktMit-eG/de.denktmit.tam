package de.denktmit.tam.webapp.model.business;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "\"user\"")
@NaturalIdCache
@Getter
@Setter
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Id
    @Column(name = "id")
    private Long id;
   
    @Column(name = "login_name")
    @NaturalId
    @NotBlank
    private final String loginName;
   
    @Column(name = "login_password")
    @NotBlank
    private String loginPassword;
   
    @Column(name = "role")
    @NotBlank
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

    private UserEntity() {
        this.loginName = null;
    }

    public UserEntity(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(loginName, that.loginName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginName);
    }
}
