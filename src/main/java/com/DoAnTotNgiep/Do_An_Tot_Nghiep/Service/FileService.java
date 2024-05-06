package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService implements FileServiceImp {
    @Value("${fileupload.rootPath}")
    private String rootPath;
    private Path root;
    public void init() {
        try {
            root= Paths.get(rootPath);
            if(Files.notExists(root)){
                Files.createDirectories(root);
            }
        } catch (IOException e) {
            System.out.println("Không tạo được file");
        }
    }
    @Override
    public boolean saveFile(MultipartFile multipartFile) {
        try {
            init();
            Files.copy(multipartFile.getInputStream(), this.root.resolve(multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi không lưu được file"+e.getMessage());
            return false;
        }
    }

    @Override
    public Resource loadFile(String filename) {
        try {
            init();
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
