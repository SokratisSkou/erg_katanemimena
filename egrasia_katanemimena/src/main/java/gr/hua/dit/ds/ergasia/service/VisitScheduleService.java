package gr.hua.dit.ds.ergasia.service;

import gr.hua.dit.ds.ergasia.entities.Citizen;
import gr.hua.dit.ds.ergasia.entities.VisitSchedule;
import gr.hua.dit.ds.ergasia.entities.pet;
import gr.hua.dit.ds.ergasia.entities.shelter;
import gr.hua.dit.ds.ergasia.repository.VisitScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitScheduleService {
    private final VisitScheduleRepository visitScheduleRepository;

    public VisitScheduleService(VisitScheduleRepository visitScheduleRepository) {
        this.visitScheduleRepository = visitScheduleRepository;
    }
    @Transactional
    public void save(VisitSchedule visitSchedule) {
        visitScheduleRepository.save(visitSchedule);
    }




    public List<VisitSchedule> getVisitsForCitizen(Citizen citizen) {
        return visitScheduleRepository.findByCitizen(citizen);
    }

    public VisitSchedule approveVisit(Integer visitId) {
        VisitSchedule visitSchedule = visitScheduleRepository.findById(visitId)
                .orElseThrow(() -> new RuntimeException("Visit not found"));
        visitSchedule.setStatus("Approved");
        return visitScheduleRepository.save(visitSchedule);
    }

    public VisitSchedule rejectVisit(Integer visitId) {
        VisitSchedule visitSchedule = visitScheduleRepository.findById(visitId)
                .orElseThrow(() -> new RuntimeException("Visit not found"));
        visitSchedule.setStatus("Rejected");
        return visitScheduleRepository.save(visitSchedule);
    }
}
