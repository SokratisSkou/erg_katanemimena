package gr.hua.dit.ds.ergasia.repository;

import gr.hua.dit.ds.ergasia.entities.VisitSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitScheduleRepository extends JpaRepository<VisitSchedule, Integer> {
}
