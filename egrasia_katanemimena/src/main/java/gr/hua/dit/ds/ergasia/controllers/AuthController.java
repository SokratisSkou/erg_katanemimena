package gr.hua.dit.ds.ergasia.controllers;

import gr.hua.dit.ds.ergasia.entities.Role;
import gr.hua.dit.ds.ergasia.entities.user;
import gr.hua.dit.ds.ergasia.repository.RoleRepository;
import gr.hua.dit.ds.ergasia.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Set;

@Controller

public class AuthController {

    private final UserService userService;
    RoleRepository roleRepository;

    public AuthController(UserService userService,RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }
    @PostConstruct
    public void setup() {
        Role role_vet = new Role("VET");
        Role role_admin = new Role("ADMIN");
        Role role_citizen = new Role("CITIZEN");
        Role role_shelter = new Role("SHELTER");


        roleRepository.updateOrInsert(role_vet);
        roleRepository.updateOrInsert(role_admin);
        roleRepository.updateOrInsert(role_citizen);
        roleRepository.updateOrInsert(role_shelter);
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }


    @GetMapping("/register")
    public String register(Model model) {
        user user = new user();
        model.addAttribute("user",user);
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("roles", roles);
        return "auth/register";  // Return the register view
    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute user user, Model model) {

        userService.saveUser(user);

        return "auth/login";
    }



}
