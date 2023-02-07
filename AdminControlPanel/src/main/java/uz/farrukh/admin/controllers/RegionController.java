package uz.farrukh.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.farrukh.admin.services.RegionService;
import uz.farrukh.library.entities.Place;
import uz.farrukh.library.entities.Region;

import java.util.List;

@Controller
@RequestMapping("/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping
    public String places(Model model) {

        List<Region> regions = regionService.findAll();


        model.addAttribute("regions", regions);
        return "regions/regions";
    }

    @GetMapping("/add")
    public String add(Model model) {

        System.out.println("Keldi");

        Region region = new Region();

        model.addAttribute("region", region);
        return "regions/form";
    }

    @PostMapping("/add")
    public String save(Region region, Model model) {

        regionService.save(region);
        return "redirect:/regions";
    }
}
