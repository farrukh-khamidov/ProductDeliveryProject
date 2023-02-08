package uz.farrukh.admin.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.farrukh.admin.services.PlaceService;
import uz.farrukh.library.entities.Place;
import uz.farrukh.library.entities.Region;
import uz.farrukh.library.repositories.PlaceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;
    @Override
    public Place save(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public List<Place> findAll() {
        return (List<Place>) placeRepository.findAll();
    }
}
