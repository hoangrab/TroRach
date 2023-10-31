package com.vinahouse.repository;

import com.vinahouse.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepositoty extends JpaRepository<Role,Integer> {
}
