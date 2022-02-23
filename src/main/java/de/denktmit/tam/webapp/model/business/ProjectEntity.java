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
public class ProjectEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Id
    @Column(name = "id")
    private Long id;
   
    @Column(name = "name")
    @NotBlank
    @NaturalId
    private final String name;
   
    @Column(name = "fk_customer_id")
    @NotNull
    private final Long fkCustomerId;

    private ProjectEntity() {
        this.fkCustomerId = null;
        this.name = null;
    }

    public ProjectEntity(String name, Long fkCustomerId) {
        this.name = name;
        this.fkCustomerId = fkCustomerId;
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
