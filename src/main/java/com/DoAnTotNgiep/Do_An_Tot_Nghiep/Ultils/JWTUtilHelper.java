package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Ultils;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.CustomUserDetails;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.User;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.User_Role;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Set;
import java.util.stream.Collectors;

@Component
// Thể hiện dùng chung
public class JWTUtilHelper {
    @Value("${jwt.privateKey}")
    private String jwtToken;
    @Autowired
    UserRepository userService;

    public String generateToken(String data) {
        // Mã hóa token
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtToken));
        // Bắn ra các jwt tương ứng
        String jws = Jwts.builder().subject(data).signWith(key).compact();
        return jws;
    }

    public CustomUserDetails veryfindToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtToken));
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token).getBody();
        String username = claims.getSubject();
        System.out.println(username);
        User user = userService.findByUsername(username);


        if (user != null) {
            Set<User_Role> roles = user.getUser_roles();
            // Tiếp tục xử lý với userRoles ở đây
            Set<GrantedAuthority> authorities = roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role.getRole().getRolename()))
                    .collect(Collectors.toSet());
            return new CustomUserDetails(user, authorities);
        } else {
            // Xử lý khi user là null
            throw new UsernameNotFoundException("User not found with username: " + username);

        }

    }
}
