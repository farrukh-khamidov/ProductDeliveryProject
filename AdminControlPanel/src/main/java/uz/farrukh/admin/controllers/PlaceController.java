package uz.farrukh.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.farrukh.admin.services.PlaceService;
import uz.farrukh.admin.services.RegionService;
import uz.farrukh.library.entities.Place;
import uz.farrukh.library.entities.Region;

import java.util.List;

@Controller
@RequestMapping("/places")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;
    private final RegionService regionService;

    @GetMapping
    public String places(Model model) {
        model.addAttribute("places", placeService.findAll());
        return "places/places";
    }

    @GetMapping("/add")
    public String add(Model model) {


        Place place = new Place();

        model.addAttribute("place", place);
        model.addAttribute("regions", regionService.findAll());
        return "places/form";
    }

    @PostMapping("/add")
    public String save(Place place, Model model) {

        System.out.println(place);
        placeService.save(place);
        return "redirect:/places";
    }
}
