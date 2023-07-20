package pet.shop.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import pet.shop.petshop.dto.AnimalDto;
import pet.shop.petshop.model.Animal;
import pet.shop.petshop.model.Tutor;
import pet.shop.petshop.service.AnimalService;
import pet.shop.petshop.service.TutorService;

@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private TutorService tutorService;

    @GetMapping("animal/consultar/{id}")
    public ModelAndView consultarAnimalOne(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("animal/listarAnimalOne");
        mav.addObject("animal", animalService.one(id));
        return mav;
    }

    @GetMapping("animal/consultar/todos")
    public ModelAndView consultarAnimalAll() {
        ModelAndView mav = new ModelAndView("animal/listarAnimalAll");
        mav.addObject("animais", animalService.all());
        return mav;
    }

    @PostMapping("/animal/cadastrar")
    public String cadastrarAnimalForm(AnimalDto animal) {
        animalService.save(animal.toAnimal());
        return "redirect:/animal/cadastrar";
    }

    @GetMapping("animal/cadastrar")
    public ModelAndView cadastrarAnimalForm() {
        ModelAndView mav = new ModelAndView("/animal/formCadastrarAnimal");
        List<Tutor> tutores = tutorService.all();
        mav.addObject("tutores", tutores);
        return mav;
    }

    @GetMapping("animal/alterar/{id}")
    public ModelAndView alterarAnimal(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("animal/alterarAnimalModal");

        mav.addObject("animal", animalService.one(id));
        mav.addObject("tutores", tutorService.all());
        return mav;
    }

    // TO-DO: Alterar para PutMapping
    @PostMapping("animal/alterar/{id}")
    public String alterarAnimal(@PathVariable Long id, AnimalDto dto) {
        animalService.update(dto.toAnimal(), id);
        return "redirect:/animal/alterar/" + id;
    }

    @GetMapping("animal/deletar/{id}")
    public ModelAndView deletarAnimalView(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("animal/deletarAnimal");
        Animal animal = animalService.one(id);
        mav.addObject("animal", animal);
        return mav;
    }

    @DeleteMapping("animal/deletar/{id}") 
    public ModelAndView deletarAnimalOne(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("redirect:/animal/consultar/todos");
        animalService.delete(id);


        return mav;
    }
    
}
