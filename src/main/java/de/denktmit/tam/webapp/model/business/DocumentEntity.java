package de.denktmit.tam.webapp.model.business;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "document")
@NaturalIdCache
public class DocumentEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Id
    @Column(name = "id")
    private long id;
   
    @Column(name = "doc_uuid")
    @Type(type="pg-uuid")
    @NotBlank
    @NaturalId
    private final UUID docUuid;
   
    @Column(name = "name")
    @NotBlank
    private String name;
   
    @Column(name = "type")
    @NotBlank
    private String type;
   
    @Column(name = "external_identifier")
    @NotBlank
    private String externalIdentifier;
   
    @Column(name = "file_type")
    @NotBlank
    private String fileType;
   
    @Column(name = "content")
    @NotBlank
    private byte[] content;
   
    @Column(name = "created_at")
    @NotBlank
    private Instant createdAt;
   
    @Column(name = "created_by")
    @NotBlank
    private String createdBy;
   
    @Column(name = "updated_at")
    @NotBlank
    private Instant updatedAt;
   
    @Column(name = "updated_by")
    @NotBlank
    private String updatedBy;

    private DocumentEntity() {
        this.docUuid = null;
    }

    public DocumentEntity(UUID docUuid) {
        this.docUuid = docUuid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getDocUuid() {
        return docUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExternalIdentifier() {
        return externalIdentifier;
    }

    public void setExternalIdentifier(String externalIdentifier) {
        this.externalIdentifier = externalIdentifier;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocumentEntity)) return false;
        DocumentEntity that = (DocumentEntity) o;
        return Objects.equals(docUuid, that.docUuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(docUuid);
    }
}
