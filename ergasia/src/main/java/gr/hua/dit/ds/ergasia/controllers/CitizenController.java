package gr.hua.dit.ds.ergasia.controllers;

import gr.hua.dit.ds.ergasia.entities.AdoptionRequest;
import gr.hua.dit.ds.ergasia.entities.VisitSchedule;
import gr.hua.dit.ds.ergasia.service.AdoptionRequestService;
import gr.hua.dit.ds.ergasia.service.VisitScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import gr.hua.dit.ds.ergasia.service.petService;
@Controller
@RequestMapping("/citizen")
public class CitizenController {
    private final petService petService;
    private final AdoptionRequestService adoptionRequestService;
    private final VisitScheduleService visitScheduleService;

    public CitizenController(petService petService,
                             AdoptionRequestService adoptionRequestService,
                             VisitScheduleService visitScheduleService) {
        this.petService = petService;
        this.adoptionRequestService = adoptionRequestService;
        this.visitScheduleService = visitScheduleService;
    }



    @GetMapping("/pets")
    public String viewPets(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "citizen_pets"; // View for citizen to browse pets
    }

    @PostMapping("/adoption-requests")
    public String submitAdoptionRequest(@ModelAttribute AdoptionRequest request) {
        adoptionRequestService.submitRequest(request);
        return "redirect:/citizen/pets"; // Redirect back to pet list
    }

    @PostMapping("/visit-schedules")
    public String scheduleVisit(@ModelAttribute VisitSchedule visitSchedule) {
        visitScheduleService.scheduleVisit(visitSchedule);
        return "redirect:/citizen/dashboard"; // Redirect back to dashboard
    }
}
