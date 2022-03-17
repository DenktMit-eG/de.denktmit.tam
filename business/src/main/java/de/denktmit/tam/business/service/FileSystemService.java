package de.denktmit.tam.business.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface FileSystemService {
    void saveToUploads(MultipartFile file) throws IOException;
}
