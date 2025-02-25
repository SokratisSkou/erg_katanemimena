package gr.hua.dit.ds.ergasia.repository;

import gr.hua.dit.ds.ergasia.entities.AdoptionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptionRequestRepository extends JpaRepository<AdoptionRequest, Integer> {
    List<AdoptionRequest> findByStatus(String status);
    List<AdoptionRequest> findByShelterApprovalStatus(String status);
    List<AdoptionRequest> findByAdminApprovalStatus(String status);

}
