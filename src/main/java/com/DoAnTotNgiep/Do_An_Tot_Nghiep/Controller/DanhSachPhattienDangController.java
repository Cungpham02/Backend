package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachLopCamTinhDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachPhatTrienDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.DanhSachPhatTrienDangServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
public class DanhSachPhattienDangController {
    @Autowired
    private DanhSachPhatTrienDangServiceImp danhSachPhatTrienDangServiceImp;
    @Autowired
    private ResponeData responeData;
    @PostMapping("/api/dangvien/save_phattriendang")
    public ResponseEntity<ResponeData> saveAll(@RequestBody List<DanhSachPhatTrienDang> sinhVienList) {
        List<DanhSachPhatTrienDang> list = danhSachPhatTrienDangServiceImp.addListOfSinhVien(sinhVienList);
        responeData.setData(list);
        responeData.setIsSuccess(true);
        responeData.setMessage("Thêm vào danh sách phát triển đảng thành công");
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
    @GetMapping("/api/doanvien/getListDanhSachPhatTrienDang")
    public ResponseEntity<?> getListDanhSachPhatTrienDang(@RequestParam("dot") String name){
        List<DanhSachPhatTrienDang> listDanhSach=danhSachPhatTrienDangServiceImp.getListDanhSachByDot(name);
        responeData.setData(listDanhSach);
        responeData.setIsSuccess(true);
        responeData.setMessage("Lấy danh sách thành công");
        return new ResponseEntity<>(responeData,HttpStatus.OK);
    }
}
