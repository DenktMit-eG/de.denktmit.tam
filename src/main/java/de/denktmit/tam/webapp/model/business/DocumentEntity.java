package de.denktmit.tam.webapp.model.business;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "document", schema = "public", catalog = "postgres")
public class DocumentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
   
    @Column(name = "doc_uuid")
    private Object docUuid;
   
    @Column(name = "name")
    private String name;
   
    @Column(name = "type")
    private String type;
   
    @Column(name = "external_identifier")
    private String externalIdentifier;
   
    @Column(name = "file_type")
    private String fileType;
   
    @Column(name = "content")
    private byte[] content;
   
    @Column(name = "created_at")
    private Object createdAt;
   
    @Column(name = "created_by")
    private String createdBy;
   
    @Column(name = "updated_at")
    private Object updatedAt;
   
    @Column(name = "updated_by")
    private String updatedBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Object getDocUuid() {
        return docUuid;
    }

    public void setDocUuid(Object docUuid) {
        this.docUuid = docUuid;
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

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

}