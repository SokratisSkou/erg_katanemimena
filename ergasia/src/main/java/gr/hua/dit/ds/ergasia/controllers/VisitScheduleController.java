package gr.hua.dit.ds.ergasia.controllers;

import gr.hua.dit.ds.ergasia.entities.VisitSchedule;
import gr.hua.dit.ds.ergasia.service.VisitScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visit-schedules")
public class VisitScheduleController {
    private final VisitScheduleService visitScheduleService;

    public VisitScheduleController(VisitScheduleService visitScheduleService) {
        this.visitScheduleService = visitScheduleService;
    }

    @GetMapping
    public String getAllSchedules(Model model) {
        model.addAttribute("schedules", visitScheduleService.getAllSchedules());
        return "visit_schedules"; // returns a view named "visit_schedules"
    }

    @PostMapping
    public String scheduleVisit(@ModelAttribute VisitSchedule visitSchedule) {
        visitScheduleService.scheduleVisit(visitSchedule);
        return "redirect:/visit-schedules";
    }
}
