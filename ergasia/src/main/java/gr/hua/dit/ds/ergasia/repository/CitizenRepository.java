package gr.hua.dit.ds.ergasia.repository;

import gr.hua.dit.ds.ergasia.entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer>{
}
