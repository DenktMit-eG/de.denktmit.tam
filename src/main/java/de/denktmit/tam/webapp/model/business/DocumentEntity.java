package de.denktmit.tam.webapp.model.business;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "document")
@NaturalIdCache
@Getter
@Setter
public class DocumentEntity extends Auditable<String>{
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hibernate")
    @Id
    @Column(name = "id")
    private Long id;
   
    @Column(name = "doc_uuid")
    @Type(type="pg-uuid")
    @NotNull
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
    @NotNull
    private byte[] content;

    private DocumentEntity() {
        this.docUuid = null;
    }

    public DocumentEntity(UUID docUuid) {
        this.docUuid = docUuid;
    }

    public DocumentEntity(UUID docUuid, String name, String type, String externalIdentifier, String fileType,
                          @NotNull byte[] content) {
        this.docUuid = docUuid;
        this.name = name;
        this.type = type;
        this.externalIdentifier = externalIdentifier;
        this.fileType = fileType;
        this.content = content;
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
