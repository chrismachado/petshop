package pet.shop.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.shop.petshop.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{
    
}
