package mx.edu.utez.firstapp.controllers.person.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.firstapp.models.person.Person;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class PersonDto {
    private Long id;
    private String name;
    private String surname;
    private String lastname;
    private String curp;
    private LocalDate birthdate;

    public Person toEntity() {
        return new Person(name, surname, lastname, birthdate, curp);
    }
}
