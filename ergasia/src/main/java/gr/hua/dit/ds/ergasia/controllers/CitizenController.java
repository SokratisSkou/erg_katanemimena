package gr.hua.dit.ds.ergasia.controllers;

import gr.hua.dit.ds.ergasia.entities.AdoptionRequest;
import gr.hua.dit.ds.ergasia.entities.Citizen;
import gr.hua.dit.ds.ergasia.entities.VisitSchedule;
import gr.hua.dit.ds.ergasia.repository.CitizenRepository;
import gr.hua.dit.ds.ergasia.repository.ShelterRepository;
import gr.hua.dit.ds.ergasia.repository.UserRepository;
import gr.hua.dit.ds.ergasia.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/citizen")
public class CitizenController {
    private final petService petService;
    private final AdoptionRequestService adoptionRequestService;
    private final VisitScheduleService visitScheduleService;
    private final ShelterService  shelterService;
    private final CitizenRepository CitizenRepository;

    public CitizenController(petService petService,
                             AdoptionRequestService adoptionRequestService,
                             VisitScheduleService visitScheduleService, ShelterService shelterService,CitizenRepository CitizenRepository) {
        this.petService = petService;
        this.adoptionRequestService = adoptionRequestService;
        this.visitScheduleService = visitScheduleService;
        this.shelterService = shelterService;
        this.CitizenRepository = CitizenRepository;
    }



    @GetMapping("/pets")
    public String viewPets(Model model) {
        model.addAttribute("pets", petService.getApprovedPets());
        return "citizen_pets"; // View for citizen to browse pets
    }
    @GetMapping("/schedule_visit")
    public String showScheduleForm(Model model) {
        model.addAttribute("visitSchedule", new VisitSchedule());
        model.addAttribute("shelters", shelterService.getAllShelters());
        return "schedule_visit"; // A form for scheduling visits
    }

    @PostMapping
    public String scheduleVisit(@ModelAttribute VisitSchedule visitSchedule, @RequestParam Integer citizenId) {
        Citizen citizen;
        citizen = CitizenRepository.findCitizenById(citizenId);
        visitSchedule.setCitizen(citizen);
        visitScheduleService.scheduleVisit(visitSchedule);
        return "redirect:/visit-schedules"; // Redirect to a confirmation page
    }

    @PostMapping("/adoption-requests")
    public String submitAdoptionRequest(@ModelAttribute AdoptionRequest request) {
        adoptionRequestService.submitRequest(request);
        return "redirect:/citizen"; // Redirect back to citizen home page
    }

    @PostMapping("/visit-schedules")
    public String scheduleVisit(@ModelAttribute VisitSchedule visitSchedule) {
        visitScheduleService.scheduleVisit(visitSchedule);
        return "redirect:/citizen"; // Redirect back to citizen h/p
    }
}
