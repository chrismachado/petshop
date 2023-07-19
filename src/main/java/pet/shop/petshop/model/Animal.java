package pet.shop.petshop.model;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ANIMAL")
public class Animal {
    @Id
    @SequenceGenerator(
        name = "animal_sequence"
        , sequenceName = "animal_sequence"
        , allocationSize = 1
        , initialValue = 1000
        , schema = "public"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE
        , generator = "animal_sequence"
    )
    private Long id;

    @NotBlank
    private String nome;
    private LocalDate nascimento;
    private int sexo;

    @Transient
    private int idade;

    @ManyToOne
    @JoinColumn(name = "id_tutor")
    @NotNull
    private Tutor tutor;

    
    public Animal(String nome, LocalDate nascimento, int sexo) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
    }

    public int getIdade() {
        return Period.between(nascimento, LocalDate.now()).getYears();
    }

}
