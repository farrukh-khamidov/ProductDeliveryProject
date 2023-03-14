package uz.farrukh.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.farrukh.admin.services.AdminService;
import uz.farrukh.library.entities.Admin;

import java.util.List;

@Controller
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping
    public String places(Model model) {

        List<Admin> admins = adminService.findAll();


        model.addAttribute("admins", admins);
        return "admins/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Admin admin = new Admin();

        System.out.println("KELDI");

        model.addAttribute("admin", admin);
        return "admins/form";
    }

    @PostMapping("/add")
    public String save(Admin admin, Model model) {
        System.out.println(admin);

        adminService.save(admin);

        return "redirect:/admins";
    }

    @GetMapping("/{id}/enabled/{status}")
    @ResponseBody
    public boolean changeEnabledStatus(@PathVariable Long id, @PathVariable boolean status) {
        System.out.println(id);
        System.out.println(status);
        adminService.changeEnabledStatus(id, status);
        return true;
    }
}
