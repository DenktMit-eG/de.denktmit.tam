package de.denktmit.tam.webapp.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public interface FileSystemService {
    void saveToUploads(MultipartFile file) throws IOException;
}
