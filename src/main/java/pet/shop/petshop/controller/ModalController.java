package pet.shop.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pet.shop.petshop.dto.AnimalDto;
import pet.shop.petshop.model.Animal;
import pet.shop.petshop.service.AnimalService;
import pet.shop.petshop.service.TutorService;

@Controller
@RequestMapping("modals")
public class ModalController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private TutorService tutorService;

    @GetMapping("animal/{id}")
    public ModelAndView alterarAnimalModal(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("animal/alterarAnimalModal");

        mav.addObject("animal", animalService.one(id));
        mav.addObject("tutores", tutorService.all());
        return mav;
    }

    @PostMapping("animal/{id}")
    public String alterarAnimalModel(@PathVariable Long id, AnimalDto dto) {
        animalService.update(dto.toAnimal(), id);
        return "redirect:/modals/animal/" + id;
    }
    
}
