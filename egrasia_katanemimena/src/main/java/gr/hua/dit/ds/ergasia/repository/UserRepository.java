package gr.hua.dit.ds.ergasia.repository;
import gr.hua.dit.ds.ergasia.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<user, Integer> {
    Optional<user> findByEmailAndPassword(String email, String password);
    List<user> findById(int id);
    Optional<user> findByUsername(String username);
    Optional<user> findByEmail(String email);
}
