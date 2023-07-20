package pet.shop.petshop.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "TUTOR")
public class Tutor {
    @Id
    @SequenceGenerator(
        name = "tutor_sequence"
        , sequenceName = "tutor_sequence"
        , allocationSize = 5
        , initialValue = 10000
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE
        , generator = "tutor_sequence"
    )
    private Long id;
    private String nome;
    @NotNull
    private LocalDate nascimento;
    @CPF
    private String cpf;
    @Email
    private String email;
    
    public Tutor(String nome, LocalDate nascimento, @CPF String cpf, @Email String email) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.email = email;
    }
    

    
}
