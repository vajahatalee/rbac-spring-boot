package com.vajahatalee.jpa.repository;

import com.vajahatalee.jpa.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}
