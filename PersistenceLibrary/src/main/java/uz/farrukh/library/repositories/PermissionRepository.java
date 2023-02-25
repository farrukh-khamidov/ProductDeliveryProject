package uz.farrukh.library.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import uz.farrukh.library.entities.Permission;

@Repository
public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long> {

    @Query("SELECT p FROM Permission p WHERE LOWER(CONCAT(p.id, ' ', p.name)) LIKE LOWER(CONCAT('%', ?1,'%'))")
    Page<Permission> findAll(String keyword, Pageable pageable);

}
