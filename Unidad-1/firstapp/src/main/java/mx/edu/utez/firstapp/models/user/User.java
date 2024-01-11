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

    @Column(length = 40, nullable = false, unique = true)
    private String username;

    @Column(length = 150, nullable = false, unique = true)
    private String password;

    @Column(columnDefinition = "TIMESTAMP DEFAULT NOW()", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(columnDefinition = "BOOL DEFAULT true")
    private Boolean status;

    @Column(columnDefinition = "BOOL DEFAULT false")
    private Boolean blocked;
    private String token;

    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;

    @OneToOne
    @JoinColumn(name = "person_id", unique = true)
    private Person person;

}
