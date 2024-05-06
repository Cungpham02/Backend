package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceImp {
    boolean saveFile(MultipartFile multipartFile);
    Resource loadFile(String filename);
}
