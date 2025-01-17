package gr.hua.dit.ds.ergasia.repository;

import gr.hua.dit.ds.ergasia.entities.AdoptionRequest;
import gr.hua.dit.ds.ergasia.entities.Citizen;
import gr.hua.dit.ds.ergasia.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer>{
    Citizen findCitizenById(int id);
}
