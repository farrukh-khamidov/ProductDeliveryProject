package uz.farrukh.admin.services;

import uz.farrukh.library.entities.Place;
import uz.farrukh.library.entities.Region;

import java.util.List;

public interface PlaceService {
    Place save(Place place);

    List<Place> findAll();
}
