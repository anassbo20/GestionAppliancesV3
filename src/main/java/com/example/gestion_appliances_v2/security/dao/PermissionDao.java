package com.example.gestion_appliances_v2.security.dao;



import com.example.gestion_appliances_v2.security.bean.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionDao extends JpaRepository<Permission, Long> {
    public Permission findByName(String name);
}
