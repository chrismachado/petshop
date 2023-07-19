package pet.shop.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.shop.petshop.model.Tutor;

public interface TutorRepository extends  JpaRepository<Tutor, Long> {
    
}
