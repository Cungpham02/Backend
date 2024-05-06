package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Ultils;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException ex) throws IOException, ServletException {
        // Trả về một response lỗi với mã trạng thái 403 Forbidden
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write("false");
    }

}