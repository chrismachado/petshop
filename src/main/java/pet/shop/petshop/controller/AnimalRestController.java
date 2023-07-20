package pet.shop.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pet.shop.petshop.dto.AnimalDto;
import pet.shop.petshop.model.Animal;
import pet.shop.petshop.model.Tutor;
import pet.shop.petshop.service.AnimalService;
import pet.shop.petshop.service.TutorService;

@RestController
@RequestMapping("api/v1/animal")
public class AnimalRestController {

    @Autowired
    private AnimalService animalService;
    
    @Autowired
    private TutorService tutorService;

    @GetMapping("/todos")
    public List<Animal> all() {
        return animalService.all();
    }

    @GetMapping("{id}")
    public Animal one(@PathVariable Long id) {
        return animalService.one(id);
    }

    @PostMapping
    public Animal save(@RequestBody AnimalDto dto) {
        Animal animal = dto.toAnimal();
        Tutor tutor = tutorService.one(dto.tutor());
        animal.setTutor(tutor);
        
        animalService.save(animal);

        return animal;
    }

    @PutMapping("{id}")
    public Animal update(@RequestBody AnimalDto dto, @PathVariable Long id) {
        Animal animal = dto.toAnimal();

        return animalService.update(animal, id);
    }

    @DeleteMapping("{id}")
    public Animal delete(@PathVariable Long id) {
        return animalService.delete(id);
    }
}
