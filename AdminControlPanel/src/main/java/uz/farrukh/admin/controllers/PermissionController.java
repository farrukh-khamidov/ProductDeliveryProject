package uz.farrukh.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uz.farrukh.admin.services.PermissionService;
import uz.farrukh.admin.services.PlaceService;
import uz.farrukh.admin.services.RegionService;
import uz.farrukh.library.entities.Permission;
import uz.farrukh.library.entities.Place;

import javax.validation.Valid;

@Controller
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping
    public String list(Model model) {
        return listByPage(1, model);
    }

    @GetMapping("/page/{pageNum}")
    public String listByPage(@PathVariable int pageNum, Model model) {

        Page<Permission> page = permissionService.findAllByPage(pageNum);

        int startCount = (pageNum - 1) * PermissionService.PAGE_SIZE + 1;
        long endCount = startCount + PermissionService.PAGE_SIZE - 1;
        long totalCount = page.getTotalElements();

        if (endCount > totalCount) endCount = totalCount;


        model.addAttribute("permissions", page);

        model.addAttribute("startCount", startCount);
        model.addAttribute("endCount", endCount);
        model.addAttribute("totalCount", totalCount);
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

    @PostMapping("/save")
    public String save(@Valid Permission permission, Errors errors, Model model) {
        System.out.println(errors.hasErrors());
        System.out.println(errors.getAllErrors());
        if (errors.hasErrors()) {
            return "permissions/form";
        }
        System.out.println("validated");
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
