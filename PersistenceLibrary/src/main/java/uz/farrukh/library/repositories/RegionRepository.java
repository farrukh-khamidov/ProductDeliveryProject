package uz.farrukh.library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.farrukh.library.entities.Region;

@Repository
public interface RegionRepository extends CrudRepository<Region, Long> {

}
