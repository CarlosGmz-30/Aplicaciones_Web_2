package mx.edu.utez.firstapp.models.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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

    @Column(columnDefinition = "TIMESTAMP DEFAULT NOW()", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creatAdt;

    @Column(columnDefinition = "BOOL DEFAULT true")
    private boolean status;

    @Column(columnDefinition = "BOOL DEFAULT false")
    private boolean blocked;

    private String token;
}
