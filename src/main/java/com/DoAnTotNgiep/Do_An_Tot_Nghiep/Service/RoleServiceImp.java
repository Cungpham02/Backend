package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.DangVien;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.Role;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Repository.RoleRepository;
import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp.RoleService;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Role> findById(Long id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        return optionalRole;
    }
}
