package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/404")
    public String error(){
        return "404";
    }
}
