package uz.farrukh.admin.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
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
    public DataTablesOutput<Permission> findAll(Integer start, Integer length) {
        Pageable pageable = PageRequest.of(start/length, length);
        Page<Permission> page = permissionRepository.findAll(pageable);
        DataTablesOutput<Permission> output = new DataTablesOutput<>();
        output.setRecordsTotal(page.getTotalElements());
        output.setRecordsFiltered(page.getTotalElements());
        output.setData(page.getContent());
        return output;
    }

    @Override
    public Page<Permission> findAllByPage(int pageNum, int pageSize, String sortField, String sortDir, String keyword) {

        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);


        Page<Permission> page = keyword != null ? permissionRepository.findAll(keyword, pageable) : permissionRepository.findAll(pageable);

        return page;
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
