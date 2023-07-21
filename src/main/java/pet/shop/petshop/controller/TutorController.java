package pet.shop.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pet.shop.petshop.dto.TutorDto;
import pet.shop.petshop.model.Tutor;
import pet.shop.petshop.service.AnimalService;
import pet.shop.petshop.service.TutorService;

@Controller
@RequestMapping("tutor")
public class TutorController {
    
    @Autowired
    private AnimalService animalService;

    @Autowired
    private TutorService tutorService;


    @GetMapping("cadastrar")
    public String cadastrarTutorForm() {
        return "/tutor/formCadastrarTutor";
    }

    @PostMapping("cadastrar")
    public String cadastrarTutorForm(Tutor tutor) {
        tutorService.save(tutor);
        return "redirect:/tutor/cadastrar";
    }

    @GetMapping("consultar/todos")
    public ModelAndView consultarTutorTodos() {
        ModelAndView mav = new ModelAndView("tutor/listarTutorAll");
        mav.addObject("tutores", tutorService.all());
        return mav;
    }

    @GetMapping("consultar/{id}")
    public ModelAndView consultarTutorOne(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("tutor/listarTutorOne");
        mav.addObject("tutor", tutorService.one(id));
        mav.addObject("animais", animalService.findAllByIdTutor(id));
        return mav;
    }

    // TO-DO: implementar os métodos para alterar os dados do tutor
    @GetMapping("alterar/{id}")
    public ModelAndView alterarTutor(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("tutor/alterarTutor");
        mav.addObject("tutor", tutorService.one(id));
        return mav;
    }

    @PutMapping("alterar/{id}")
    public ModelAndView alterarTutor(@PathVariable Long id, TutorDto dto) {
        ModelAndView mav = new ModelAndView("tutor/alterarTutor");
        tutorService.update(id, dto.toTutor());
        return mav;
    }
    
}
