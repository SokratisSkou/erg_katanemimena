package gr.hua.dit.ds.ergasia.controllers;

import gr.hua.dit.ds.ergasia.entities.*;
import gr.hua.dit.ds.ergasia.repository.CitizenRepository;
import gr.hua.dit.ds.ergasia.repository.ShelterRepository;
import gr.hua.dit.ds.ergasia.repository.UserRepository;
import gr.hua.dit.ds.ergasia.repository.petRepository;
import gr.hua.dit.ds.ergasia.service.*;
import org.springframework.cglib.core.Local;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Timer;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/citizen")
public class CitizenController {

    private final petService petService;
    private final VisitScheduleService appointmentService;
    private final CitizenRepository citizenRepository;
    private final CitizenService citizenService;
    private final AdoptionRequestService adoptionRequestService;
    private final gr.hua.dit.ds.ergasia.repository.petRepository petRepository;


    public CitizenController(petService petService, VisitScheduleService appointmentService, CitizenRepository citizenRepository, CitizenService citizenService, AdoptionRequestService adoptionRequestService, petRepository petRepository) {
        this.petService = petService;
        this.appointmentService = appointmentService;
        this.citizenRepository = citizenRepository;
        this.citizenService = citizenService;
        this.adoptionRequestService = adoptionRequestService;
        this.petRepository = petRepository;
    }
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Add any necessary attributes to the model for the dashboard view
        return "/citizen/dashboard"; // Ensure this view exists
    }
    @GetMapping("/details")
    public String showShelterDetailsForm(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Citizen citizen = citizenRepository.findByName(userDetails.getUsername())
                .orElse(new Citizen());
        model.addAttribute("citizen", citizen);
        return "citizen/details"; // Return the form view
    }

    @PostMapping("/save_details")
    public String saveShelterDetails(@RequestParam String name,
                                     @RequestParam String surname,
                                     @RequestParam int age,
                                     @RequestParam String contactInfo,
                                     @AuthenticationPrincipal UserDetails userDetails) {
        // Get the currently logged-in user

        Citizen citizen = new Citizen();

        // Create and save the additional details
        citizen.setName(name);
        citizen.setSurname(surname);
        citizen.setContactInfo(contactInfo);
        citizen.setAge(age);




        // Save the updated admin entity
        citizenService.save(citizen);

        return "redirect:/citizen/dashboard"; // Redirect to the admin dashboard or another page
    }



    @GetMapping("/view_pets")
    public String viewAvailablePets(Model model) {
        model.addAttribute("pets", petService.getApprovedPets());
        return "citizen/view_pets";
    }
    @PostMapping("/adopt_pet")
    public String adoptPet(@RequestParam("petId") int petId,
                           @AuthenticationPrincipal UserDetails userDetails) {
        // Retrieve the current user (citizen) based on the authenticated user
        String username = userDetails.getUsername();
        pet pet = petService.findById(petId);
        Optional<Citizen> citizenOptional = citizenRepository.findByName(username);
        if (!citizenOptional.isPresent()) {
            // Handle the case where the citizen is not found
            return "redirect:/citizen/dashboard"; // Redirect to an error page
        }
        Citizen citizen = citizenOptional.get();
        AdoptionRequest request = new AdoptionRequest();
        adoptionRequestService.submitRequest(request,pet,citizen);// Implement this method in your PetService

        return "redirect:/citizen/dashboard";
    }

    @GetMapping("/request_appointment")
    public String requestAppointmentForm(Model model) {
        model.addAttribute("appointment", new VisitSchedule());
        return "citizen/request_appointment";
    }

    @PostMapping("/visit_schedule")
    public String requestAppointment(@RequestParam LocalDate date,
                                     @RequestParam LocalTime time,
                                     @RequestParam("citizenId") int citizenID,
                                     @AuthenticationPrincipal UserDetails userDetails) {
        Citizen citizen = citizenService.findById(citizenID);
        VisitSchedule appointment = new VisitSchedule();
        appointment.setCitizen(citizen);
        appointment.setVisitDate(date);
        appointment.setVisitTime(time);
        appointment.setStatus("Pending");
        appointmentService.save(appointment);
        return "citizen/request_appointment";
    }
}

