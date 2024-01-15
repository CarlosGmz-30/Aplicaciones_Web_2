package mx.edu.utez.firstapp.services.person;

import mx.edu.utez.firstapp.config.ApiResponse;
import mx.edu.utez.firstapp.models.person.Person;
import mx.edu.utez.firstapp.models.person.PersonRepository;
import mx.edu.utez.firstapp.models.role.Role;
import mx.edu.utez.firstapp.models.user.User;
import mx.edu.utez.firstapp.models.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class PersonService {
    private final PersonRepository repository;
    private final UserRepository userRepository;

    public PersonService(PersonRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAll() {
        return new ResponseEntity<>(new ApiResponse(repository.findAll(), HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> save(Person person) {
        Optional<Person> foundPerson = repository.findByCurp(person.getCurp());
        if (foundPerson.isPresent()) {
            return new ResponseEntity<>
                    (new ApiResponse(HttpStatus.BAD_REQUEST,
                            true, "RecordAlredyExist"), HttpStatus.BAD_REQUEST);
        }
        if (person.getUser() != null) {
            person.getUser().setPerson(person);
            Optional<User> foundUser = userRepository.findFirstByUsername(person.getUser().getUsername());
            if (foundUser.isPresent())
                return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true,
                        "RecordAlredyExist"), HttpStatus.BAD_REQUEST);
            Set<Role> roles = person.getUser().getRoles();
            person.getUser().setRoles(null);
            person = repository.saveAndFlush(person);
            for (Role role : roles) {
                if (userRepository.saveUserRole(person.getUser().getId(), role.getId()) <= 0) {
                    return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true,
                            "RoleNotAttached"), HttpStatus.BAD_REQUEST);
                }
            }
        }
        return new ResponseEntity<>(new ApiResponse
                (person, HttpStatus.OK), HttpStatus.OK);
    }
}



