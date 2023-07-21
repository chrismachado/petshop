package pet.shop.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pet.shop.petshop.dto.TutorDto;
import pet.shop.petshop.model.Animal;
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
    public ModelAndView cadastrarTutorForm(TutorDto dto) {
        Tutor tutor = tutorService.save(dto.toTutor());
        return new ModelAndView("redirect:/tutor/consultar/" + tutor.getId());
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
        mav.addObject("animais", animalService.allByIdTutor(id));
        return mav;
    }

    @GetMapping("alterar/{id}")
    public ModelAndView alterarTutor(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("tutor/alterarTutor");
        mav.addObject("tutor", tutorService.one(id));
        return mav;
    }

    @PutMapping("alterar/{id}")
    public ModelAndView alterarTutor(@PathVariable Long id, TutorDto dto) {
        ModelAndView mav = new ModelAndView("redirect:/tutor/consultar/" + id);
        tutorService.update(id, dto.toTutor());
        return mav;
    }

    @GetMapping("deletar/{id}")
    public ModelAndView deletarTutorView(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("tutor/deletarTutor");
        mav.addObject("tutor", tutorService.one(id));

        return mav;
    }

    @DeleteMapping("deletar/{id}")
    public ModelAndView deletarTutorOne(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("redirect:/tutor/consultar/todos");
        for(Animal animal : animalService.allByIdTutor(id)) {
            animalService.delete(animal.getId());
        }
        Tutor tutor = tutorService.delete(id);

        return mav;
    }
    
}
