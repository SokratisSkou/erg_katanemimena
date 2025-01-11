package gr.hua.dit.ds.ergasia.controllers;

import gr.hua.dit.ds.ergasia.entities.AdoptionRequest;
import gr.hua.dit.ds.ergasia.service.AdoptionRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adoption-requests")
public class AdoptionRequestController {
    private final AdoptionRequestService adoptionRequestService;

    public AdoptionRequestController(AdoptionRequestService adoptionRequestService) {
        this.adoptionRequestService = adoptionRequestService;
    }

    @GetMapping
    public String getAllRequests(Model model) {
        model.addAttribute("requests", adoptionRequestService.getAllRequests());
        return "adoption_requests"; // returns a view named "adoption_requests"
    }

    @PostMapping
    public String submitRequest(@ModelAttribute AdoptionRequest request) {
        adoptionRequestService.submitRequest(request);
        return "redirect:/adoption-requests";
    }
}