package uz.farrukh.admin.services;

import uz.farrukh.library.entities.Region;

import java.util.List;

public interface RegionService {
    Region save(Region region);

    List<Region> findAll();
}
