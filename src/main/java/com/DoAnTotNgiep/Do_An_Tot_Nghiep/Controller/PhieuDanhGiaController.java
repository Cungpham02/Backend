package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;


import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVienPhieuDanhGia;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.PhieuDanhGia;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.DangVienPhieuDanhGiaServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.DangVienServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.PhieuDanhGiaServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.PhieuDanhGiaDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/phieudanhgia")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PhieuDanhGiaController {
    @Autowired
    private PhieuDanhGiaServiceImp phieuDanhGiaServiceImp;
    @Autowired
    private DangVienServiceImp dangVienServiceImp;
    @Autowired
    private DangVienPhieuDanhGiaServiceImp dangVienPhieuDanhGiaServiceImp;
    @Autowired
    private ResponeData responeData;
    @GetMapping("")
    public ResponseEntity<?> getAllPhieuDanhGia() {
        return ResponseEntity.ok(phieuDanhGiaServiceImp.getAllPhieuDanhGia());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> readImage(@PathVariable Long id) {
        PhieuDanhGia image = phieuDanhGiaServiceImp.getPhieuDanhGia(id);
        return ResponseEntity.ok()
                .body(image.getData());
    }


    @PostMapping("")
    public ResponseEntity<?> uploadPhieuDanhGia(@RequestParam("fileData") MultipartFile file,@RequestParam("chonDot")String chonDot) {
        PhieuDanhGia phieuDanhGia=phieuDanhGiaServiceImp.uploadPhieuDanhGia(file,chonDot);
        List<DangVien> dangVienList=dangVienServiceImp.getListDangVien();
        dangVienPhieuDanhGiaServiceImp.addDangVienPhieuDanhGia(phieuDanhGia,dangVienList);
        responeData.setMessage("Tạo mới phiếu đáng giá thành công");
        responeData.setIsSuccess(true);
        responeData.setData(phieuDanhGia);
        return new ResponseEntity<>(responeData, HttpStatus.CREATED);
    }



    @GetMapping("/download/{id}")
    public ResponseEntity<?> downloadImage(@PathVariable Long id) {
        PhieuDanhGia phieuDanhGia = phieuDanhGiaServiceImp.getPhieuDanhGia(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(phieuDanhGia.getName()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + phieuDanhGia.getName() + "\"")
                .body(new ByteArrayResource(phieuDanhGia.getData()));
    }

    // Xóa ảnh
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteImage(@PathVariable Long id) {
        phieuDanhGiaServiceImp.deletePhieuDanhGia(id);
        return ResponseEntity.noContent().build(); // 204
    }
    @GetMapping("/getByIdAndByDot")
    public ResponseEntity<?> getPhieuDanhGiaByDotAndDangVienId(@RequestParam("dot") String dot, @RequestParam("id_dangvien") Long dangvienId) {
        PhieuDanhGia phieuDanhGia=phieuDanhGiaServiceImp.getPhieuDanhGiaByIdDVAndByDot(dot, dangvienId);
        DangVienPhieuDanhGia dangVienPhieuDanhGia=dangVienPhieuDanhGiaServiceImp.findByID(phieuDanhGia.getId(),dangvienId);
        responeData.setData(phieuDanhGia);
        responeData.setIsSuccess(true);
        if (phieuDanhGia != null && dangVienPhieuDanhGia.getActive()==false) {
            return ResponseEntity.ok().body(phieuDanhGia.getData());
        } else {
            return ResponseEntity.ok().body("");
        }
    }
    @GetMapping("/getByDotDanhGia")
    public ResponseEntity<?> getPhieuDanhGiaByDot(@RequestParam("chonDot") String dotd) {
        PhieuDanhGia phieuDanhGia=phieuDanhGiaServiceImp.phieuDanhGiaByDot(dotd);
        responeData.setData(phieuDanhGia);
        responeData.setIsSuccess(true);
        return new ResponseEntity<>(responeData,HttpStatus.OK);
    }
}

