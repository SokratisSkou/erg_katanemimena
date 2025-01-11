package gr.hua.dit.ds.ergasia.repository;

import gr.hua.dit.ds.ergasia.entities.AdoptionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionRequestRepository extends JpaRepository<AdoptionRequest, Integer> {
}
