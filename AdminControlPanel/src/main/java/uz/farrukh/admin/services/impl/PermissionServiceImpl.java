package uz.farrukh.admin.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page<Permission> findAll(Pageable pageable) {
        return permissionRepository.findAll(pageable);
    }

    @Override
    public Permission findById(Long id) {
        return permissionRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        permissionRepository.deleteById(id);
    }

    @Override
    public Page<Permission> findAllByPage(int pageNum, int pageSize) {

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Permission> page = permissionRepository.findAll(pageable);

        System.out.println("PageNum = " + pageNum);
        System.out.println("Total elements = " + page.getTotalElements());
        System.out.println("Total pages = " + page.getTotalPages());

        return page;
    }
}
