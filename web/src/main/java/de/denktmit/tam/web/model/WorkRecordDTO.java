package de.denktmit.tam.web.model;

import de.denktmit.tam.persistence.model.DocumentEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class WorkRecordDTO {
    private Long id;
    private Long contractId;
    private Short billingYear;
    private Short billingMonth;
    private Instant uploadDate;
    private DocumentEntity timeSheet;
    private DocumentEntity creditNote;
    private DocumentEntity invoice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkRecordDTO)) return false;
        WorkRecordDTO that = (WorkRecordDTO) o;
        return Objects.equals(contractId, that.contractId) && Objects.equals(billingYear,
                that.billingYear) && Objects.equals(billingMonth, that.billingMonth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId, billingYear, billingMonth);
    }
}
