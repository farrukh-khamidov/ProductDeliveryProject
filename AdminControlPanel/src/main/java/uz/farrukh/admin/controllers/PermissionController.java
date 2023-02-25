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
        return listByPage(1, 10, "name", "asc", null, model);
    }

    @GetMapping("/page/{pageNum}/size/{pageSize}")
    public String listByPage(@PathVariable int pageNum, @PathVariable int pageSize,
                             @RequestParam String sortField,
                             @RequestParam String sortDir,
                             @RequestParam(required = false) String keyword,
                             Model model) {

        Page<Permission> page = permissionService.findAllByPage(pageNum, pageSize, sortField, sortDir, keyword);


        long startCount = (long) (pageNum - 1) * pageSize + 1;
        long endCount = startCount + pageSize - 1;
        if (endCount > page.getTotalElements()) endCount = page.getTotalElements();

        String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("currentSize", pageSize);

        model.addAttribute("startCount", startCount);
        model.addAttribute("endCount", endCount);
        model.addAttribute("totalCount", page.getTotalElements());
        model.addAttribute("totalPages", page.getTotalPages());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", reverseSortDir);
        model.addAttribute("keyword", keyword);

        model.addAttribute("permissions",page.getContent());
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
