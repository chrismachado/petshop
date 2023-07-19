package pet.shop.petshop.dto;

import java.time.LocalDate;
import java.time.Period;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pet.shop.petshop.model.Animal;
import pet.shop.petshop.model.Tutor;

public record AnimalDto(
    @NotBlank @NotNull String nome
    , @NotNull LocalDate nascimento
    , @NotNull int sexo
    , Long tutor
) {
    public Animal toAnimal() {
        Tutor t = new Tutor();
        t.setId(tutor);
        Animal animal = new Animal(nome, nascimento, sexo);
        animal.setTutor(t);
        return animal;
    }

    public int getIdade() {
        return Period.between(nascimento, LocalDate.now()).getYears();
    }
}
