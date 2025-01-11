package gr.hua.dit.ds.ergasia.repository;
import gr.hua.dit.ds.ergasia.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<user, Integer> {
}
