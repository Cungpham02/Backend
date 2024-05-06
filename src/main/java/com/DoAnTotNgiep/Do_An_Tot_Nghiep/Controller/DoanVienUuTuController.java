package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DanhSachLopCamTinhDang;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DoanVienUuTu;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.DoanVienUuTuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class DoanVienUuTuController {
    @Autowired
    private DoanVienUuTuServiceImp doanVienUuTuServiceImp;
    @Autowired
    private ResponeData responeData;
    @GetMapping("/api/doanvienuutu/ds_doanvienuutu")
    public ResponseEntity<ResponeData> getAllDanhSachByDot(@RequestParam("dotdoanvienuutu") String name) {
        List<DoanVienUuTu> list = doanVienUuTuServiceImp.getListDanhSachByDot(name);
        responeData.setData(list);
        responeData.setIsSuccess(true);
        responeData.setMessage("Lấy ra danh sách đoàn viên ưu tú theo đợt thành công");
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
}
