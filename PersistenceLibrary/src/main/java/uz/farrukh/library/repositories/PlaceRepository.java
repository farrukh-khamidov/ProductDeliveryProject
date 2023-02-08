package uz.farrukh.library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.farrukh.library.entities.Place;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long> {

}
