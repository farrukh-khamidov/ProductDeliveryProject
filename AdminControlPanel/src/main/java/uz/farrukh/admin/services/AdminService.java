package uz.farrukh.admin.services;

import uz.farrukh.library.entities.Admin;

import java.util.List;

public interface AdminService {
    Admin save(Admin region);

    List<Admin> findAll();

    void changeEnabledStatus(Long id, boolean enabled);
}
