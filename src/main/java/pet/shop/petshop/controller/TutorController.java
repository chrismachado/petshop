package pet.shop.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pet.shop.petshop.dto.TutorDto;
import pet.shop.petshop.model.Tutor;
import pet.shop.petshop.service.TutorService;

@RestController
@RequestMapping("api/v1/tutor")
public class TutorController {
    

    @Autowired
    private TutorService tutorService;

    @GetMapping("/todos")
    public List<Tutor> all() {
        return tutorService.all();
    }

    @GetMapping("{id}")
    public Tutor one(@PathVariable Long id) {
        return tutorService.one(id);
    }
    
    @PostMapping
    public Tutor save(@RequestBody TutorDto dto) {
        Tutor tutor = dto.toTutor();
        tutorService.save(tutor);
        return tutor;
    }



}
