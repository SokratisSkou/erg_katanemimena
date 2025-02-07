package gr.hua.dit.ds.ergasia.repository;
import gr.hua.dit.ds.ergasia.entities.Admin;
import gr.hua.dit.ds.ergasia.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findBySurname(String username);


}
