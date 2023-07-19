package pet.shop.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import pet.shop.petshop.dto.AnimalDto;
import pet.shop.petshop.model.Animal;
import pet.shop.petshop.model.Tutor;
import pet.shop.petshop.service.AnimalService;
import pet.shop.petshop.service.TutorService;

@Controller
public class CadastroController {
    
    @Autowired
    private AnimalService animalService;

    @Autowired
    private TutorService tutorService;


    @PostMapping("/animal/cadastrar")
    public String cadastrarAnimalForm(AnimalDto animal) {
        animalService.save(animal.toAnimal());
        return "redirect:/animal/cadastrar";
    }

    @GetMapping("/animal/cadastrar")
    public ModelAndView cadastrarAnimalForm() {
        ModelAndView mav = new ModelAndView("/animal/formCadastrarAnimal");
        List<Tutor> tutores = tutorService.all();
        mav.addObject("tutores", tutores);
        return mav;
    }

    @GetMapping("/tutor/cadastrar")
    public String cadastrarTutorForm() {
        return "/tutor/formCadastrarTutor";
    }

    @PostMapping("/tutor/cadastrar")
    public String cadastrarTutorForm(Tutor tutor) {
        tutorService.save(tutor);
        return "redirect:/tutor/cadastrar";
    }
}
