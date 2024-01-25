package mx.edu.utez.firstapp.models.person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByCurp(String curp);

    Optional<Person> findByName(String name);

    Page<Person> findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCaseOrCurpContainingIgnoreCase(String name, String surname, String curp, Pageable pageable);
    Optional<Person> findByCurpAndIdNot(String curp, Long id);
}
