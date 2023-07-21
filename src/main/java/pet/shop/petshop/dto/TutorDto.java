package pet.shop.petshop.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pet.shop.petshop.model.Tutor;

public record TutorDto(
    @NotBlank String nome
    , @NotNull LocalDate nascimento
    , @NotBlank String cpf
    , @NotBlank String email
) {
    public Tutor toTutor() {
        return new Tutor(nome, nascimento, cpf, email);
    }
}
