package gr.hua.dit.ds.ergasia.repository;

import gr.hua.dit.ds.ergasia.entities.Citizen;
import gr.hua.dit.ds.ergasia.entities.VisitSchedule;
import gr.hua.dit.ds.ergasia.entities.shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitScheduleRepository extends JpaRepository<VisitSchedule, Integer> {

    List<VisitSchedule> findByCitizen(Citizen citizen);
}
