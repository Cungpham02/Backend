package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponeData {
    private int status;
    private String message;
    private Boolean isSuccess = false;
    private Object data;
    private String username;
}
