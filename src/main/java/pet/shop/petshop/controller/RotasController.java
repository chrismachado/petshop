package pet.shop.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RotasController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/db")
    public String h2() {
        return "redirect:/h2-ui";
    }

    
}
