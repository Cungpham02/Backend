package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachDangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.DanhSachDangVienServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@Controller
@RequestMapping(value = "/api/ds")
public class DanhSachDangVienController {
    @Autowired
    private DanhSachDangVienServiceImp danhSachDangVienServiceImp;
    @Autowired
    private ResponeData responeData;
    @GetMapping("/getList")
    public ResponseEntity<?> getListDanhSach(){
        List<DanhSachDangVien> lists=danhSachDangVienServiceImp.getListDanhSach();
        responeData.setData(lists);
        responeData.setIsSuccess(true);
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
    @PostMapping("/deleteByListId")
    public ResponseEntity<?> deleteDangVienByIds(@RequestBody List<Long> ids) {
        System.out.println(ids);
        danhSachDangVienServiceImp.deleteDangVienByIds(ids);
        responeData.setMessage("Xóa danh sách thành công");
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
}
