package pet.shop.petshop.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.shop.petshop.model.Animal;
import pet.shop.petshop.repository.AnimalRepository;

@Service
public class AnimalService {
    
    @Autowired
    private AnimalRepository repository;

    public List<Animal> all() {
        return repository.findAll();
    }

    public Animal one(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void save(Animal animal) {
        repository.save(animal);
    }

    public Animal update(Animal animal, Long id) {
        return repository.findById(id)
            .map(
                animalModel -> {
                    BeanUtils.copyProperties(animal, animalModel);
                    animalModel.setId(id);
                    return repository.save(animalModel);
                })
            .orElseGet(
                () -> {
                    animal.setId(id);
                    return repository.save(animal);
                }
            );
    }

    public Animal delete(Long id) {
        Animal animal = repository.findById(id).orElseThrow();
        repository.deleteById(id);
        return animal;
    }

    public List<Animal> findAllByIdTutor(Long idTutor) {
        return repository.findAllByIdTutor(idTutor);
    }
}
