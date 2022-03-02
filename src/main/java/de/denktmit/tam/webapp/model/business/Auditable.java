package de.denktmit.tam.webapp.model.business;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class Auditable<U> {

    @CreatedBy
    @Column(name = "created_by")
    protected U createdBy;

    @CreatedDate
    @Column(name = "creation_date")
    protected Instant creationDate;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    protected U lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    protected Instant lastModifiedDate;
}
