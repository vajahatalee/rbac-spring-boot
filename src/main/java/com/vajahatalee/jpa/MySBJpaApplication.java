package com.vajahatalee.jpa;

import com.vajahatalee.jpa.model.Role;
import com.vajahatalee.jpa.model.RolePermission;
import com.vajahatalee.jpa.model.Permission;
import com.vajahatalee.jpa.repository.RoleRepository;
import com.vajahatalee.jpa.repository.PermissionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Date;

@SpringBootApplication
public class MySBJpaApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(MySBJpaApplication.class);

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    public static void main(String[] args) {
        SpringApplication.run(MySBJpaApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        Role roleX = new Role("RoleX");
        Permission permissionX = new Permission("PermissionX");

        RolePermission rolePermission = new RolePermission();
        rolePermission.setRole(roleX);
        rolePermission.setPermission(permissionX);
        rolePermission.setAssignedDate(new Date());
        roleX.getRolePermissions().add(rolePermission);

        permissionRepository.save(permissionX);
        roleRepository.save(roleX);

        // validate
        System.out.println(roleX.getRolePermissions().size());

    }
}
