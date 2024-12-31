package gr.hua.dit.ds.ergasia.controllers;
import gr.hua.dit.ds.ergasia.entities.Citizen;
import gr.hua.dit.ds.ergasia.repository.CitizenRepository;
import gr.hua.dit.ds.ergasia.service.CitizenService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("citizen")
public class CitizenContoller {
    CitizenService citizenService;
    public CitizenContoller(CitizenService citizenService) {this.citizenService = citizenService;}
    



}
