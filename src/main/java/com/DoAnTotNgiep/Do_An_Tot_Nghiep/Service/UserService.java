package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.CustomUserDetails;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.User;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.User_Role;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Lỗi không thấy username trong csdl");
        }
        Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        Set<User_Role> roles = user.getUser_roles();
        for (User_Role userRoles : roles) {
            grantedAuthoritySet.add(new SimpleGrantedAuthority(userRoles.getRole().getRolename()));
        }
        return new CustomUserDetails(user, grantedAuthoritySet);
    }
}
