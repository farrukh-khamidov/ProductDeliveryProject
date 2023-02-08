package uz.farrukh.admin.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.farrukh.admin.services.PermissionService;
import uz.farrukh.library.entities.Permission;
import uz.farrukh.library.repositories.PermissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    @Override
    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public List<Permission> findAll() {
        return (List<Permission>) permissionRepository.findAll();
    }

    @Override
    public Permission findById(Long id) {
        return permissionRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        permissionRepository.deleteById(id);
    }
}
