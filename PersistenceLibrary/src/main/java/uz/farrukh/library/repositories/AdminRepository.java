package uz.farrukh.library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.farrukh.library.entities.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {

}
