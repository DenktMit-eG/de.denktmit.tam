package de.denktmit.tam.webapp.model.business;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "project")
@NaturalIdCache
@Getter
@Setter
public class ProjectEntity extends Auditable<String> {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Id
    @Column(name = "id")
    private Long id;
   
    @Column(name = "name")
    @NotBlank
    @NaturalId
    private final String name;
   
    @JoinColumn(name = "fk_customer_id")
    @ManyToOne
    @NotNull
    private final CustomerEntity customer;

    private ProjectEntity() {
        this.customer = null;
        this.name = null;
    }

    public ProjectEntity(String name, CustomerEntity customer) {
        this.name = name;
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectEntity)) return false;
        ProjectEntity that = (ProjectEntity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
