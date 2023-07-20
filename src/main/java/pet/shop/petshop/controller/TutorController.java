package pet.shop.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import pet.shop.petshop.dto.AnimalDto;
import pet.shop.petshop.model.Tutor;
import pet.shop.petshop.service.AnimalService;
import pet.shop.petshop.service.TutorService;

@Controller
public class TutorController {
    
    @Autowired
    private AnimalService animalService;

    @Autowired
    private TutorService tutorService;


    @GetMapping("tutor/cadastrar")
    public String cadastrarTutorForm() {
        return "/tutor/formCadastrarTutor";
    }

    @PostMapping("tutor/cadastrar")
    public String cadastrarTutorForm(Tutor tutor) {
        tutorService.save(tutor);
        return "redirect:/tutor/cadastrar";
    }

    @GetMapping("tutor/consultar/todos")
    public ModelAndView consultarTutorTodos() {
        ModelAndView mav = new ModelAndView("tutor/listarTutorAll");
        mav.addObject("tutores", tutorService.all());
        return mav;
    }

    @GetMapping("tutor/consultar/{id}")
    public ModelAndView consultarTutorOne(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("tutor/listarTutorOne");
        mav.addObject("tutor", tutorService.one(id));
        mav.addObject("animais", animalService.allByIdTutor(id));
        return mav;
    }
}
