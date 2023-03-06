package uz.farrukh.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uz.farrukh.admin.services.PermissionService;
import uz.farrukh.admin.services.PlaceService;
import uz.farrukh.admin.services.RegionService;
import uz.farrukh.library.dtos.DatatableOutput;
import uz.farrukh.library.entities.Permission;
import uz.farrukh.library.entities.Place;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping
    public String list(Model model) {
        return "permissions/list";
    }

    @GetMapping("/list")
    public String list2(Model model) {
        return "permissions/list2";
    }

    @GetMapping("/ajax")
    @ResponseBody
    public DatatableOutput<Permission> listAjax(@RequestParam Map<String, Object> filter) {
        System.out.println(filter);
        return permissionService.findAll(PageRequest.of(0, 10));
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

    @PostMapping("/save")
    public String save(@Valid Permission permission, Errors errors, Model model) {
        System.out.println("KELDI");
        System.out.println(errors.hasErrors());

        if (errors.hasErrors()) {
            return "permissions/form";
        }

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
