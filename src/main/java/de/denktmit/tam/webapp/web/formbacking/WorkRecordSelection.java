package de.denktmit.tam.webapp.web.formbacking;

import org.springframework.web.context.annotation.SessionScope;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@SessionScope
public class WorkRecordSelection {

    @NotNull
    @Min(1)
    private Long workRecordId;

    public Long getWorkRecordId() {
        return workRecordId;
    }

    public void setWorkRecordId(Long workRecordId) {
        this.workRecordId = workRecordId;
    }
}
