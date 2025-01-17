package gr.hua.dit.ds.ergasia.repository;

import gr.hua.dit.ds.ergasia.entities.pet;
import gr.hua.dit.ds.ergasia.entities.shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShelterRepository  extends JpaRepository<shelter, Integer> {
    List<shelter> findByAprovalStatus(String approvalStatus);
}
