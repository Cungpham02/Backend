package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.dto.StudentRecord;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class DataComparisonController {
    @PostMapping("/compare")
    public Map<String, Object> compareData(@RequestBody Map<String, Object> requestData) {
        List<StudentRecord> file1Data = convertToStudentRecords((List<Map<String, Object>>) requestData.get("data1"));
        List<StudentRecord> file2Data = convertToStudentRecords((List<Map<String, Object>>) requestData.get("data2"));

        boolean isDataMatched = compareData(file1Data, file2Data);

        Map<String, Object> response = new HashMap<>();
        response.put("isDataMatched", isDataMatched);

        return response;
    }

    private List<StudentRecord> convertToStudentRecords(List<Map<String, Object>> data) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(data, new TypeReference<List<StudentRecord>>() {});
    }

    private boolean compareData(List<StudentRecord> list1, List<StudentRecord> list2) {
        // Loại bỏ cột "ketqua" (hoặc "dottrongnam") khi so sánh
        list1.forEach(studentRecord -> studentRecord.setKetqua(null));
        list2.forEach(studentRecord -> studentRecord.setKetqua(null));

        // So sánh hai danh sách dữ liệu
        return list1.equals(list2);
    }
}
