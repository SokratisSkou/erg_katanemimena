package gr.hua.dit.ds.ergasia.repository;
import gr.hua.dit.ds.ergasia.entities.Citizen;
import gr.hua.dit.ds.ergasia.entities.vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VetRepository extends JpaRepository<vet, Integer> {
    vet findByName(String username);

}
