package uz.farrukh.library.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.farrukh.library.entities.Permission;

@Repository
public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long> {

    boolean existsByName(String name);

    @Query("SELECT p from Permission p WHERE LOWER(CONCAT(p.id, ' ', p.name)) LIKE CONCAT('%', LOWER(:keyword), '%')")
    Page<Permission> findAll(@Param("keyword") String keyword, Pageable pageable);

}
