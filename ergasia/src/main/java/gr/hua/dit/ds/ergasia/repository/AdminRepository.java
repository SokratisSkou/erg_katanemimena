package gr.hua.dit.ds.ergasia.repository;
import gr.hua.dit.ds.ergasia.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    public Admin findByUsername(String username);
    public Admin findByID(Long id);
}
