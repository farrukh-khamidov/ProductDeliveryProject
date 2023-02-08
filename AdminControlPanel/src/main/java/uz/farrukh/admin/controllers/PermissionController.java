package uz.farrukh.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.farrukh.admin.services.PermissionService;
import uz.farrukh.admin.services.PlaceService;
import uz.farrukh.admin.services.RegionService;
import uz.farrukh.library.entities.Permission;
import uz.farrukh.library.entities.Place;

@Controller
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping
    public String places(Model model) {
        model.addAttribute("permissions", permissionService.findAll());
        return "permissions/list";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("permission", new Permission());
        return "permissions/form";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id,  Model model) {
        System.out.println(id);

        Permission permission = permissionService.findById(id);

        model.addAttribute("permission", permission);
        return "permissions/form";
    }

    @PostMapping("/add")
    public String save(Permission permission, Model model) {

        System.out.println(permission);
        permissionService.save(permission);
        return "redirect:/permissions";
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public boolean delete(@PathVariable Long id) {
        System.out.println(id);
        permissionService.deleteById(id);
        return true;
    }
}
