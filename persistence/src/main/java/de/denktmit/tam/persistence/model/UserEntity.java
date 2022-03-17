package de.denktmit.tam.persistence.model;

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
public class UserEntity extends Auditable<String> {
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
   
    @Column(name = "address_country_iso_code")
    private String addressCountryIsoCode;
   
    @Column(name = "address_zip")
    private String addressZip;
   
    @Column(name = "address_city")
    private String addressCity;
   
    @Column(name = "address_street")
    private String addressStreet;

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
