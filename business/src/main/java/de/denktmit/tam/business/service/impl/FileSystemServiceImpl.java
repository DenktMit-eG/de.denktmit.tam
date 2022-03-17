package de.denktmit.tam.business.service.impl;

import de.denktmit.tam.business.service.Directories;
import de.denktmit.tam.business.service.FileSystemService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;

@Service
public class FileSystemServiceImpl implements FileSystemService {

    @Override
    public void saveToUploads(MultipartFile file) throws IOException {
        Path path = Paths.get(Directories.UPLOADS, "FILEUPLOAD_" + Instant.now().toString());
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
    }
}
