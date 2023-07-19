package pet.shop.petshop.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import pet.shop.petshop.model.Tutor;

public record TutorDto(
    @NotBlank String nome
    , @PastOrPresent LocalDate nascimento
    , @NotBlank String cpf
    , @NotBlank String email
) {
    public Tutor toTutor() {
        return new Tutor(nome, nascimento, cpf, email);
    }
}
