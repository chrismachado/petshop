package pet.shop.petshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pet.shop.petshop.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{
    
    @Query(
        value = "select a.id, a.nome, a.nascimento, a.sexo, a.id_tutor from animal a where a.id_tutor=:id_tutor"
        , nativeQuery = true)
    List<Animal> findAllByIdTutor(@Param("id_tutor") Long idTutor);
}
