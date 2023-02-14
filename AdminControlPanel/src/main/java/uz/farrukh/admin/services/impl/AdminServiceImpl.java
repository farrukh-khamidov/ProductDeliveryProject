package uz.farrukh.admin.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.farrukh.admin.services.AdminService;
import uz.farrukh.library.entities.Admin;
import uz.farrukh.library.entities.Region;
import uz.farrukh.library.repositories.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> findAll() {
        return (List<Admin>) adminRepository.findAll();
    }

    @Override
    public void updateEnabledStatus(Long id, boolean status) {
        Optional<Admin> optional = adminRepository.findById(id);
        if (optional.isEmpty()) throw new RuntimeException();
        Admin admin = optional.get();
        admin.setEnabled(status);
        adminRepository.save(admin);
    }
}
