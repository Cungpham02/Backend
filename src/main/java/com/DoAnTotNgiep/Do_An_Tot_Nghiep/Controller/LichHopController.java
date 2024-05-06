package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.LichHop;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.ResponeData;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.LichHopServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
public class LichHopController {
    @Autowired
    private LichHopServiceImp lichHopServiceImp;
    @Autowired
    private ResponeData responeData;
    @GetMapping("/api/lichhop/getAll")
    public ResponseEntity<?> getAll(){
        List<LichHop> list=lichHopServiceImp.getList();
        if(list!=null){
            responeData.setMessage("Lấy danh sách thành công");
            responeData.setIsSuccess(true);
            responeData.setData(list);
            return  new ResponseEntity<>(responeData, HttpStatus.OK);
        }else{
            responeData.setMessage("Danh sách rỗng");
            responeData.setIsSuccess(false);
            responeData.setData(list);
            return  new ResponseEntity<>(responeData, HttpStatus.OK);
        }

    }
    @GetMapping("/api/lichhop/getLichHopById")
    public ResponseEntity<?> getLichHopById(@RequestParam("id") Long id){
          LichHop lichHop=lichHopServiceImp.findById(id);
            responeData.setMessage("Lấy ra thành công");
            responeData.setIsSuccess(true);
            responeData.setData(lichHop);
            return  new ResponseEntity<>(responeData, HttpStatus.OK);
    }
    @PostMapping("/api/lichhop/save")
    public ResponseEntity<?> saveLichHop(@RequestBody LichHop lichHop){
       lichHopServiceImp.saveLichHop(lichHop);
       responeData.setMessage("Tạo lịch họp thành công");
       responeData.setIsSuccess(true);
       return  new ResponseEntity<>(responeData, HttpStatus.OK);
    }
}
