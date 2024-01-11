package mx.edu.utez.firstapp.models.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.firstapp.models.user.User;

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
    private Long id;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 40, nullable = false)
    private String surname;

    @Column(length = 40)
    private String lastname;

    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate birtdate;

    @Column(length = 18, nullable = false, unique = true)
    private String curp;

    @Column(columnDefinition = "TIMESTAMP DEFAULT NOW()", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(columnDefinition = "BOOL DEFAULT true")
    private Boolean status;

    @OneToOne(mappedBy = "person", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties(value = {"person"})
    private User user;

}