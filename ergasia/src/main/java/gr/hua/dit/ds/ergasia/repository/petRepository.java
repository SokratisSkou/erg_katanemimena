package gr.hua.dit.ds.ergasia.repository;
import gr.hua.dit.ds.ergasia.entities.Citizen;
import gr.hua.dit.ds.ergasia.entities.pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface petRepository extends JpaRepository<pet, Integer> {
    List<pet> findByApprovalStatus(String approvalStatus);

    List<pet> findByHealthStatus(String heathStatus);
    List<pet> findByHealthStatusAndApprovalStatus(String healthStatus, String approvalStatus);
}
