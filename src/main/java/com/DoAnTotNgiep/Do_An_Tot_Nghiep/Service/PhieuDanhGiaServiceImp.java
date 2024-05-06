package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.PhieuDanhGia;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.PhieuDanhGiaRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.PhieuDanhGiaService;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Ultils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhieuDanhGiaServiceImp {
    private final PhieuDanhGiaRepository phieuDanhGiaRepository;
    private final FileUtils fileUtils;
    public List<PhieuDanhGia> getAllPhieuDanhGia() {
        return phieuDanhGiaRepository.findByOrderByCreatedAtDesc();
    }

    public PhieuDanhGia getPhieuDanhGia(Long id) {
        return phieuDanhGiaRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not found image with id = " + id);
        });
    }

    public PhieuDanhGia uploadPhieuDanhGia(MultipartFile file,String chonDot) {
        fileUtils.validateFile(file);

        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            PhieuDanhGia phieuDanhGia = new PhieuDanhGia(fileName, file.getBytes(),chonDot);
            return phieuDanhGiaRepository.save(phieuDanhGia);
        } catch (Exception e) {
            throw new RuntimeException("Upload Phiếu đánh giá error");
        }
    }
    public PhieuDanhGia getPhieuDanhGiaByIdDVAndByDot(String dot,Long id_dangvien) {
        return phieuDanhGiaRepository.findByChonDotAndDangVienPhieuDanhGiaDangVienId(dot,id_dangvien);
    }

    public void deletePhieuDanhGia(Long id) {
        PhieuDanhGia phieuDanhGia = phieuDanhGiaRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not found image with id = " + id);
        });

        phieuDanhGiaRepository.delete(phieuDanhGia);
    }
    public PhieuDanhGia phieuDanhGiaByDot(String dot) {
        PhieuDanhGia phieuDanhGia = phieuDanhGiaRepository.findPhieuDanhGiaByDot(dot);
        return phieuDanhGia;
    }
}
