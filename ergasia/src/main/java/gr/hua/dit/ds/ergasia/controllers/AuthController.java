package gr.hua.dit.ds.ergasia.controllers;

import gr.hua.dit.ds.ergasia.entities.Role;
import gr.hua.dit.ds.ergasia.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {


    RoleRepository roleRepository;

    public AuthController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void setup() {
        Role role_admin = new Role("ROLE_ADMIN");
        Role role_vet = new Role("ROLE_VET");
        Role role_shelter = new Role("ROLE_SHELTER");
        Role role_citizen = new Role("ROLE_CITIZEN");


        roleRepository.updateOrInsert(role_vet);
        roleRepository.updateOrInsert(role_admin);
        roleRepository.updateOrInsert(role_shelter);
        roleRepository.updateOrInsert(role_citizen);
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
}
