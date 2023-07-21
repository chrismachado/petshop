package pet.shop.petshop.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.shop.petshop.model.Tutor;
import pet.shop.petshop.repository.TutorRepository;

@Service
public class TutorService {
    
    @Autowired
    private TutorRepository repository;
    
    public void save(Tutor tutor) {
        repository.save(tutor);
    }

    public Tutor one(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Tutor> all() {
        return repository.findAll();
    }

    public Tutor update(Long id, Tutor tutor) {
        return repository.findById(id)
            .map(tutorModel -> {
                BeanUtils.copyProperties(tutor, tutorModel);
                tutorModel.setId(id);
                return repository.save(tutorModel);
            }).orElseGet(
                () -> {
                    tutor.setId(id);
                    return repository.save(tutor);
                }
            );
    }

}
