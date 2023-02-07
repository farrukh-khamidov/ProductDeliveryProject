package uz.farrukh.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.farrukh.library.entities.Place;
import uz.farrukh.library.entities.Region;

import java.util.List;

@Controller
@RequestMapping("/places")
public class PlaceController {

    @GetMapping
    public String places(Model model) {

        List<Place> places = List.of(
                new Place(1L, "Yunusobod"),
                new Place(2L, "Chilonzor")
        );


        model.addAttribute("places", places);
        return "places/places";
    }

    @GetMapping("/add")
    public String add(Model model) {


        Place place = new Place();

        model.addAttribute("place", place);
        return "places/add";
    }

    @PostMapping("/add")
    public String save(Place place, Model model) {

        System.out.println(place);
        return "redirect:/places";
    }
}
