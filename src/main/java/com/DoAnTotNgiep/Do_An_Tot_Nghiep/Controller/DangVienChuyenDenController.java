package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVienDangVienChuyenDen;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DvChuyenDen;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.DangVienChuyenDenImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.DangVienDangVienChuyenDenServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.DangVienServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.DangVienChuyenDenDTO;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.DangVienDTO;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.DvChuyenDenDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@Controller
@RequestMapping(value = "/api/dvchuyenden/")

public class DangVienChuyenDenController {
    @Autowired
    private DangVienServiceImp dangVienServiceImp;
    @Autowired
    private ResponeData responeData;
    @Autowired
    private DangVienChuyenDenImp dangVienChuyenDenImp;
    @Autowired
    private DangVienDangVienChuyenDenServiceImp dangVienDangVienChuyenDenServiceImp;

    @PostMapping(value = "add")
    @PreAuthorize("hasRole('ROLE_BT')")
    public ResponseEntity<?> addPartyMember(@RequestBody DvChuyenDenDTO dvChuyenDenDTO) throws JsonProcessingException {
        String partyMemberInfoJson=dvChuyenDenDTO.getPartyMemberInfo();
        ObjectMapper objectMapper = new ObjectMapper();

        // Chuyển đổi chuỗi JSON thành đối tượng DangVien
        DangVien dangVien2 = objectMapper.readValue(partyMemberInfoJson, DangVien.class);
        System.out.println(dangVien2.getId());

//        System.out.println(dvChuyenDenDTO.getId());
//        // Tìm kiếm đảng viên
//
//
//        // Tìm kiếm đảng viên bằng mdd
        DangVien dangVien1 = dangVienServiceImp.findByMDD(dvChuyenDenDTO.getMdd());

        // Kiểm tra nếu đảng viên không tồn tại
        if (dangVien1 == null) {
            System.out.println(dangVienServiceImp.checkPhone(dvChuyenDenDTO.getPhonenumber()));

            // Kiểm tra nếu số điện thoại đã tồn tại trong cơ sở dữ liệu
            if (dangVienServiceImp.checkPhone(dvChuyenDenDTO.getPhonenumber())) {
                System.out.println(dangVienServiceImp.checkPhone(dvChuyenDenDTO.getPhonenumber()));
                responeData.setMessage("Số điện thoại đã tồn tại trong cơ sở dữ liệu");
                responeData.setIsSuccess(false);
                return new ResponseEntity<>(responeData, HttpStatus.OK);
            }

            // Tạo mới DvChuyenDen
            DvChuyenDen dvChuyenDen = new DvChuyenDen();
            dvChuyenDen.setFullname(dvChuyenDenDTO.getFullname());
            dvChuyenDen.setMdd(dvChuyenDenDTO.getMdd());
            dvChuyenDen.setPhonenumber(dvChuyenDenDTO.getPhonenumber());
            Date currentDate = new Date();
            dvChuyenDen.setNgaychuyenden(new java.sql.Date(currentDate.getTime()));
            dvChuyenDenDTO.setTrangthai(false);

            // Lưu DvChuyenDen
            dangVienChuyenDenImp.save(dvChuyenDen);

            // Tạo mới DangVienDangVienChuyenDen
            DangVienDangVienChuyenDen dangVienDangVienChuyenDen = new DangVienDangVienChuyenDen();

            dangVienDangVienChuyenDen.setDangVien(dangVien2);
            System.out.println(dangVienDangVienChuyenDen.getDangVien().getId()+"-" + dangVienDangVienChuyenDen.getDangVien().getFullname());
            dangVienDangVienChuyenDen.setDvChuyenDen(dvChuyenDen);
            dangVienDangVienChuyenDen.setTrangthai("notConfirmed");

            // Lưu DangVienDangVienChuyenDen
            dangVienDangVienChuyenDenServiceImp.save(dangVienDangVienChuyenDen);
            responeData.setMessage("Thêm mới thành công 1 đảng viên chuyển đến");
            responeData.setIsSuccess(true);
            return new ResponseEntity<>(responeData, HttpStatus.OK);
        } else {
            // Trả về thông báo lỗi khi đảng viên có mã định danh đã tồn tại
            responeData.setMessage(
                    "Đảng viên có mã định danh " + dvChuyenDenDTO.getMdd().toString() + " đã tồn tại trong csdl");
            responeData.setIsSuccess(false);
            return new ResponseEntity<>(responeData, HttpStatus.OK);
        }
    }

    @PreAuthorize("hasRole('ROLE_BT')")
    @GetMapping(value = "getListChuyenDen")
    public ResponseEntity<ResponeData> getListDvChuyenDen() {
        List<DangVienChuyenDenDTO> list_dv_chuyen_den = dangVienChuyenDenImp.getListDS();
        responeData.setData(list_dv_chuyen_den);
        responeData.setIsSuccess(true);
        responeData.setStatus(200);
        responeData.getMessage();
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_BT')")
    @GetMapping(value = "findByFullnameHuongDan")
    public ResponseEntity<ResponeData> getListDvChuyenDen(@RequestParam("fullname") String fullname) {
        List<DangVienChuyenDenDTO> list_dv_chuyen_den = dangVienChuyenDenImp.getListDSByFullname(fullname);
        responeData.setData(list_dv_chuyen_den);
        responeData.setIsSuccess(true);
        responeData.setStatus(200);
        responeData.getMessage();
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
//    @PreAuthorize("hasRole('ROLE_BT')")
//    @GetMapping(value = "getListDS")
//    public ResponseEntity<ResponeData> getListDvChuyenDenDS() {
//        List<DangVienChuyenDenDTO> list_dv_chuyen_den = dangVienChuyenDenImp.getListDS();
//        responeData.setData(list_dv_chuyen_den);
//        responeData.setIsSuccess(true);
//        responeData.setStatus(200);
//        responeData.getMessage();
//        return new ResponseEntity<>(responeData, HttpStatus.OK);
//    }
}
