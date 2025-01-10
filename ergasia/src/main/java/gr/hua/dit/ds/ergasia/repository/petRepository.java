package gr.hua.dit.ds.ergasia.repository;
import gr.hua.dit.ds.ergasia.entities.Citizen;
import gr.hua.dit.ds.ergasia.entities.pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface petRepository extends JpaRepository<pet, Integer> {

}
