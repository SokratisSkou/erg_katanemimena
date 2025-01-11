package gr.hua.dit.ds.ergasia.service;

import gr.hua.dit.ds.ergasia.entities.VisitSchedule;
import gr.hua.dit.ds.ergasia.repository.VisitScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitScheduleService {
    private final VisitScheduleRepository visitScheduleRepository;

    public VisitScheduleService(VisitScheduleRepository visitScheduleRepository) {
        this.visitScheduleRepository = visitScheduleRepository;
    }

    public VisitSchedule scheduleVisit(VisitSchedule visitSchedule) {
        return visitScheduleRepository.save(visitSchedule);
    }

    public List<VisitSchedule> getAllSchedules() {
        return visitScheduleRepository.findAll();
    }
}