package uz.farrukh.admin.services;

import uz.farrukh.library.entities.Permission;

import java.util.List;

public interface PermissionService {
    Permission save(Permission permission);

    List<Permission> findAll();

    Permission findById(Long id);

    void deleteById(Long id);
}
