package gr.hua.dit.ds.ergasia.controllers;
import gr.hua.dit.ds.ergasia.entities.Citizen;
import gr.hua.dit.ds.ergasia.repository.CitizenRepository;
import gr.hua.dit.ds.ergasia.service.CitizenService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/citizens")
public class CitizenContoller {
    List<Citizen> citizens = new ArrayList<Citizen>();
    @PostConstruct
    public void populate() {


        Citizen c1 = new Citizen(1 ,"s","f", "S", 23 );
        Citizen c2 = new Citizen(2,"s","r","f", 22);
        Citizen c3 = new Citizen(3,"f","r","n",21);
        citizens.add(c1);
        citizens.add(c2);
        citizens.add(c3);


    }
    @GetMapping("")
    public String showCitizens(Model model) {
        model.addAttribute("citizens", citizens);
        return "citizens";
    }


}
