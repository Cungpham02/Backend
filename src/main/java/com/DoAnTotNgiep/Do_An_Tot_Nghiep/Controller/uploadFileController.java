package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
public class uploadFileController {
    @Autowired
    private FileService fileService;
    @PostMapping("/uploads")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("file2") MultipartFile file2,
                                        @RequestParam("file3") MultipartFile file3,@RequestParam("file4") MultipartFile file4,
                                        @RequestParam("file5") MultipartFile file5,@RequestParam("file6") MultipartFile file6,
                                        @RequestParam("file7") MultipartFile file7,@RequestParam("file8") MultipartFile file8,@RequestParam("mssv") String mssv){
        System.out.println(mssv);
        ResponeData responeData=new ResponeData();
        fileService.saveFile(file);
        fileService.saveFile(file2);
        fileService.saveFile(file3);
        fileService.saveFile(file4);
        fileService.saveFile(file5);
        fileService.saveFile(file6);
        fileService.saveFile(file7);
        fileService.saveFile(file8);
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<?> getFile(@PathVariable String filename){

        Resource file=fileService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
