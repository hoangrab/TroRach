package com.vinahouse.services;

import com.vinahouse.models.Role;
import com.vinahouse.repository.RoleRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepositoty roleRepositoty;

    public Role saveRole(Role role) {
        return roleRepositoty.save(role);
    }
}
