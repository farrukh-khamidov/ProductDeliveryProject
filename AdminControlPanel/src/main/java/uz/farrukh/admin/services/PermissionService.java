package uz.farrukh.admin.services;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import uz.farrukh.library.entities.Permission;

import java.util.List;

public interface PermissionService {
    Permission save(Permission permission);

    List<Permission> findAll();
    DataTablesOutput<Permission> findAll(Integer start, Integer length);

    Page<Permission> findAllByPage(int pageNum, int pageSize, String sortField, String sortDir, String keyword);

    Permission findById(Long id);

    void deleteById(Long id);
}
