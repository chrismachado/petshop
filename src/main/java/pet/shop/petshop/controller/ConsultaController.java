package pet.shop.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import static org.springframework.http.HttpStatus.OK;

import pet.shop.petshop.service.AnimalService;

@Controller
public class ConsultaController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("animal/consultar/{id}")
    public ModelAndView consultarAnimalOne(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("animal/listarUmAnimal", OK);
        mav.addObject("animais", animalService.one(id));
        return mav;
    }

    @GetMapping("animal/consultar/todos")
    public ModelAndView consultarAnimalTodos() {
        ModelAndView mav = new ModelAndView("animal/listarTodosAnimal", OK);
        mav.addObject("animais", animalService.all());
        return mav;
    }
    
}
