package uz.farrukh.admin.services;

import org.springframework.data.domain.Page;
import uz.farrukh.library.entities.Permission;

import java.util.List;
import java.util.Map;

public interface PermissionService {
    Permission save(Permission permission);

    List<Permission> findAll();
    Map<String, Object> findAll(Map<String, Object> params);

    Page<Permission> findAllByPage(int pageNum, int pageSize, String sortField, String sortDir, String keyword);

    Permission findById(Long id);

    void deleteById(Long id);
}
