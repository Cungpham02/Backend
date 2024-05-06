package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.DangVienDangVienChuyenDenServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.DangVienDangVienChuyenDenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin("*")
@Controller
@RequestMapping(value = "/api/dvdvcd")
public class DangVienDangVienChuyenDenController {
    @Autowired
    private ResponeData responeData;
    @Autowired
    private DangVienDangVienChuyenDenServiceImp dangVienDangVienChuyenDenServiceImp;
    @PostMapping("/update-trangthai")
    public ResponseEntity<?> updateStatus(@RequestBody List<DangVienDangVienChuyenDenDTO> dtoList) {
        try {
            dangVienDangVienChuyenDenServiceImp.updateTrangThai(dtoList);
            responeData.setIsSuccess(true);
            responeData.setMessage("Cập nhật thành công");
            return ResponseEntity.ok(responeData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating status");
        }
    }
}
