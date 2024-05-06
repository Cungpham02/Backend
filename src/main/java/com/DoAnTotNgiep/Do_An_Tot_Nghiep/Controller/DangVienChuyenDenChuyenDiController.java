package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import java.util.List;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.*;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.*;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.MyRequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/dvcdcd/")
public class DangVienChuyenDenChuyenDiController {
    @Autowired
    private ResponeData responeData;

    @Autowired
    private DangVienChuyenDenImp dangVienChuyenDenImp;
    @Autowired
    private DangVienChuyenDiImp dangVienChuyenDiImp;

    @Autowired
    private DangVienServiceImp dangVienServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private DanhSachDangVienServiceImp danhSachDangVienServiceImp;



    @PreAuthorize("hasRole('ROLE_BT')")
    @GetMapping(value = "getListChuyenDi")
    public ResponseEntity<ResponeData> getListDvChuyenDi() {
        List<DvChuyenDi> list_dv_chuyen_di = dangVienChuyenDiImp.getListDvChuyenDi();
        responeData.setData(list_dv_chuyen_di);
        responeData.setIsSuccess(true);
        responeData.setStatus(200);
        responeData.getMessage();
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_DV')")
    @PostMapping("yeucauchuyendi")
    public ResponseEntity<ResponeData> yeucauChuyenDi(@RequestBody DvChuyenDi dvChuyenDi,
            @RequestParam("username") String username) {
        ResponeData responeData = new ResponeData();
        User user1 = userServiceImp.findByUsername(username);
        DangVien dv = dangVienServiceImp.findById2(user1.getDangVien().getId());
        if (dv != null) {
            dvChuyenDi.setUsername(username);
            dvChuyenDi.setFullname(user1.getDangVien().getFullname());
            dvChuyenDi.setTrangthai("0");
            dangVienChuyenDiImp.saveyecauChuyenDi(dvChuyenDi);
            responeData.setIsSuccess(true);
            responeData.setMessage("Yêu cầu của bạn đã được gửi đi");
            return new ResponseEntity<>(responeData, HttpStatus.OK);
        } else {
            responeData.setIsSuccess(false);
            responeData.setMessage("Đảng viên " + dvChuyenDi.getFullname() + " không tồn tại trong csdl");
            return new ResponseEntity<>(responeData, HttpStatus.OK);

        }

    }

    @PostMapping("seachByID/{id}")
    public ResponseEntity<ResponeData> searchById(@PathVariable("id") Long id) {
        DvChuyenDi dvChuyenDi=dangVienChuyenDiImp.searchDVById(id);
        ResponeData responeData = new ResponeData();
        responeData.setMessage("Lấy đảng viên theo id thành công");
        responeData.setData(dvChuyenDi);
        responeData.setIsSuccess(true);
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
    @GetMapping("seachByUsername/{username}")
    public ResponseEntity<ResponeData> searchByUsername(@PathVariable("username") String username) {
        DvChuyenDi dvChuyenDi=dangVienChuyenDiImp.findByUsername(username);
        ResponeData responeData = new ResponeData();
        responeData.setMessage("Lấy đảng viên theo username thành công");
        responeData.setData(dvChuyenDi);
        responeData.setIsSuccess(true);
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_BT')")
    @PostMapping("xacnhanYeuCauChuyenDi/{id}/{username}")
    public ResponseEntity<ResponeData> xacnhanYecauChuyenDi(@PathVariable("id") String id,
            @PathVariable("username") String fullname, @RequestBody MyRequestData myRequestData) {
        String trangthai = myRequestData.getTrangthai();
        // Tìm kiếm User theo username
        User user = userServiceImp.findByUsername(fullname);
        System.out.println(user.getUsername());
        DangVien dangVien = user.getDangVien();
        DanhSachDangVien danhSachDangVien=danhSachDangVienServiceImp.findByFullName(dangVien.getFullname());
        danhSachDangVienServiceImp.deleteDanhSachDangVienById(danhSachDangVien.getId());
        // DangVien dangVien = dangVienServiceImp.findByFullname(fullname);
        // User user = userServiceImp.findByDangVien(dangVien);
        Long id_dangvien = Long.parseLong(id);
        dangVienChuyenDiImp.updateDangVienChuyenDIById(id_dangvien,trangthai);
        if(trangthai.equals("2")){
            user.setTrangthai("0");
            dangVien.setTrangthai(false);
            dangVienServiceImp.saveDangVien(dangVien);
            userServiceImp.saveUser(user);
        }
        ResponeData responeData = new ResponeData();
        responeData.setMessage("Đảng viên chuyển đi thành công");
        responeData.setIsSuccess(true);
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
}
