package mx.edu.utez.firstapp.models.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.firstapp.models.person.Person;
import mx.edu.utez.firstapp.models.role.Role;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 40)
    private String username;

    @Column(unique = true, nullable = false, length = 150)
    private String password;

    // Este es para ingresar directamente lenguaje SQL
    @Column(columnDefinition = "TIMESTAMP DEFAULT NOW()", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creatAdt;

    @Column(columnDefinition = "BOOL DEFAULT true")
    private boolean status;

    @Column(columnDefinition = "BOOL DEFAULT false")
    private boolean blocked;

    private String token;

    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;

    @OneToOne
    @JoinColumn(name = "person_id", unique = true)
    private Person person;
}
