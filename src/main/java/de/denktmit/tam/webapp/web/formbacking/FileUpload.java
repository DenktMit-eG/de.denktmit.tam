package de.denktmit.tam.webapp.web.formbacking;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class FileUpload {

    @NotNull
    private MultipartFile multipartFile;
    private boolean succesfull = false;

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public boolean isSuccesfull() {
        return succesfull;
    }

    public void setSuccesfull(boolean succesfull) {
        this.succesfull = succesfull;
    }
}
