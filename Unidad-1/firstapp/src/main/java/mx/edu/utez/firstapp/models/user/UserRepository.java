package mx.edu.utez.firstapp.models.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByUsername(String username);

    /* Method queries
    1. Buscar a todos los usuarios por medio del estado
    2. Buscar a un usuario por medio del id de la persona
    3. Buscar al usuario por medio del curp de la persona
     */

    List<User> findAllByStatus(boolean status);

    Optional<User> findByPersonId(Long id);

    Optional<User> findByPersonCurp(String curp);

    @Query(value = "SELECT * FROM users u " +
            "INNER JOIN people p ON u.person_id = p.id " +
            "WHERE p.birth_date BETWEEN :fechaUno AND :fechaDos ",
            nativeQuery = true)
    List<User> obtenerUsuariosPorFechasDeNacimiento(@Param("fechaUno") String startDate,
                                                    @Param("fechaDos") String endDate);

}
