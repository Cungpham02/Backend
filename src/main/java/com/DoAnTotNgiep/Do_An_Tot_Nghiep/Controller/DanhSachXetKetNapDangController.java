package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachKetNapDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachPhatTrienDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachXetKetNapDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.DanhSachXetKetNapServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
public class DanhSachXetKetNapDangController {
    @Autowired
    private ResponeData responeData;
    @Autowired
    private DanhSachXetKetNapServiceImp danhSachXetKetNapServiceImp;

    @PostMapping("/api/dangvien/save_xetketnapdang")
    public ResponseEntity<ResponeData> saveAll(@RequestBody List<DanhSachXetKetNapDang> sinhVienList) {
        List<DanhSachXetKetNapDang> list = danhSachXetKetNapServiceImp.addListOfSinhVien(sinhVienList);
        responeData.setData(list);
        responeData.setIsSuccess(true);
        responeData.setMessage("Thêm vào danh sách xét kêt nạp đảng thành công");
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
    @GetMapping("/api/doanvien/getListDanhSachKetNapDang")
    public ResponseEntity<?> getListDanhSachPhatTrienDang(@RequestParam("dot") String name){
        List<DanhSachXetKetNapDang> listDanhSach=danhSachXetKetNapServiceImp.getListDanhSachByDot(name);
        responeData.setData(listDanhSach);
        responeData.setIsSuccess(true);
        responeData.setMessage("Lấy danh sách thành công");
        return new ResponseEntity<>(responeData,HttpStatus.OK);
    }
}
