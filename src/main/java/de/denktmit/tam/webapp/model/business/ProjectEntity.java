package de.denktmit.tam.webapp.model.business;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "project")
public class ProjectEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Id
    @Column(name = "id")
    private long id;
   
    @Column(name = "name")
    private String name;
   
    @Column(name = "fk_customer_id")
    private long fkCustomerId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFkCustomerId() {
        return fkCustomerId;
    }

    public void setFkCustomerId(long fkCustomerId) {
        this.fkCustomerId = fkCustomerId;
    }

}
