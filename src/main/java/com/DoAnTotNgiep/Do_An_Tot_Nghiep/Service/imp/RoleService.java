package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Service.imp;

import java.util.Optional;

import com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity.Role;

public interface RoleService {
    Optional<Role> findById(Long id);
}
