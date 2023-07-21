package pet.shop.petshop.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.shop.petshop.model.Tutor;
import pet.shop.petshop.repository.AnimalRepository;
import pet.shop.petshop.repository.TutorRepository;

@Service
public class TutorService {
    
    @Autowired
    private TutorRepository tutorRepository;
    
    @Autowired
    private AnimalRepository animalRepository;
    
    public Tutor save(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public Tutor one(Long id) {
        return tutorRepository.findById(id).orElseThrow();
    }

    public List<Tutor> all() {
        return tutorRepository.findAll();
    }

    public Tutor update(Long id, Tutor tutor) {
        return tutorRepository.findById(id)
            .map(tutorModel -> {
                BeanUtils.copyProperties(tutor, tutorModel);
                tutorModel.setId(id);
                return tutorRepository.save(tutorModel);
            }).orElseGet(
                () -> {
                    tutor.setId(id);
                    return tutorRepository.save(tutor);
                }
            );
    }

    public Tutor delete(Long id) {
        Tutor tutor = tutorRepository.findById(id).orElseThrow();
        tutorRepository.deleteById(id);
        return tutor;
    }

}
