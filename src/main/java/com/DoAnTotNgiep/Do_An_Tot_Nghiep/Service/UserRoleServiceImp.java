package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.Role;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.User_Role;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.RoleRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.UserRoleRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.RoleService;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.UserRoleService;

@Service
public class UserRoleServiceImp implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public void saveUserRole(User_Role user_Role) {
        userRoleRepository.save(user_Role);
    }
}
