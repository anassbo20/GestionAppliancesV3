package com.example.gestion_appliances_v2.security.service.impl;


import com.example.gestion_appliances_v2.security.bean.Permission;
import com.example.gestion_appliances_v2.security.dao.PermissionDao;
import com.example.gestion_appliances_v2.security.service.facade.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public Permission save(Permission permission) {
        Permission perm = permissionDao.findByName(permission.getName());
        return perm == null ? permissionDao.save(permission) : perm;
    }
}
