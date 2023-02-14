package uz.farrukh.library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import uz.farrukh.library.entities.Permission;

@Repository
public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long> {

}
