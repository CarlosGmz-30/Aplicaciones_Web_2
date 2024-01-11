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

    /*
    1. Buscar a todos los usuarios por medio del status
    2. Buscar a un usuario por medio del ID de la persona
    3. Buscar al usuario por medio del curp de la persona
     */
    List<User> findAllByStatus(Boolean status);

    Optional<User> findByPersonId(Long id);
    Optional<User> findByPersonCurp(String curp);

    @Query(value =
            "SELECT * from users u INNER JOIN people p on u.person_id = p.id " +
                    "where p.birthdate BETWEEN :fechaUno and :fechaDos",
            nativeQuery = true)
    List<User> getUser(@Param("fechaUno") String startDate,
                                    @Param("fechaUno") String startEnd);
}
