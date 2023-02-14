package uz.farrukh.admin.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.farrukh.library.entities.Permission;

import java.util.List;

public interface PermissionService {
    int PAGE_SIZE = 2;
    Permission save(Permission permission);

    List<Permission> findAll();
    Page<Permission> findAll(Pageable pageable);

    Permission findById(Long id);

    void deleteById(Long id);

    Page<Permission> findAllByPage(int pageNum, int pageSize);
}
