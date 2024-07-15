package br.ufrn.imd.ITHelper.service;

import br.ufrn.imd.ITHelper.model.Image;
import br.ufrn.imd.ITHelper.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ImageService {
    private static final String UPLOAD_DIR = "/path/to/upload/dir/";

    @Autowired
    private ImageRepository repository;

    public Image savePhoto(MultipartFile file) throws IOException {
        String filePath = UPLOAD_DIR + file.getOriginalFilename();
        file.transferTo(new File(filePath));

        Image image = new Image();
        image.setPhotoPath(filePath);
        Image newImage = repository.saveAndFlush(image);

        return newImage;
    }

    public byte[] getPhoto(Long id) throws IOException {
        String photoPath = repository.findById(id).orElseThrow(() -> new RuntimeException("Photo not found")).getPhotoPath();
        return Files.readAllBytes(Paths.get(photoPath));
    }
}
