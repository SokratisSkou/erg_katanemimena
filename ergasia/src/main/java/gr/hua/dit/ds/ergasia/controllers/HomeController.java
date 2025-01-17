package gr.hua.dit.ds.ergasia.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(Model model) {

        model.addAttribute("title", "Home");
        return "index";
    }
}

