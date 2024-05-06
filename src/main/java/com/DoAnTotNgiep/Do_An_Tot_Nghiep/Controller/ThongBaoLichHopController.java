package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.LichHop;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.User;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.DangVienServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.ThongBaoLichHopServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.UserServiceImp;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.ThongBaoLichHopDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
public class ThongBaoLichHopController {
    @Autowired
    private ThongBaoLichHopServiceImp thongBaoLichHopServiceImp;
    @Autowired
    private ResponeData responeData;
    @Autowired
    private UserServiceImp userServiceImp;
    @PostMapping("/thongbaolichhop")
    public ResponseEntity<String> addThongBaoLichHop(@RequestBody ThongBaoLichHopDTO dto) {
        thongBaoLichHopServiceImp.addThongBaoLichHop(dto.getLichHopId(), dto.getDanhSachDangVienIds());
        return ResponseEntity.ok("Thông báo lịch họp đã được tạo.");
    }
    @GetMapping("/api/listDangVienChuaNhanThongBao")
    public ResponseEntity<?> getListDangVienChuaNhanTHongBao(@RequestParam("id") Long id) {
        List<DangVien> list=thongBaoLichHopServiceImp.findDangVienChuaNhanThongBao(id);
        responeData.setData(list);
        responeData.setIsSuccess(true);
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_DV')")
    @GetMapping("/api/listThongBaoBY_idDangVien")
    public ResponseEntity<?>getListThongBaoByIdDangVien(@RequestParam("username") String username){
        User user=userServiceImp.findByUsername(username);
        List<LichHop> list=thongBaoLichHopServiceImp.getListLichHopById(user.getDangVien().getId());
        responeData.setData(list);
        responeData.setIsSuccess(true);
        return new ResponseEntity<>(responeData, HttpStatus.OK);
    }
}
