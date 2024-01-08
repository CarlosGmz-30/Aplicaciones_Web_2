package mx.edu.utez.firstapp.models.person;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "people")
@NoArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 40, nullable = false)
    private String surname;

    @Column(length = 40)
    private String lastname;

    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate birthdate;

    @Column(length = 18, nullable = false, unique = true)
    private String curp;

    // Este es para ingresar directamente lenguaje SQL
    @Column(columnDefinition = "TIMESTAMP DEFAULT NOW()", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creatAdt;

    @Column(columnDefinition = "BOOL DEFAULT true")
    private boolean status;


}
