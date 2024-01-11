package mx.edu.utez.firstapp.config;

import mx.edu.utez.firstapp.models.person.PersonRepository;
import mx.edu.utez.firstapp.models.role.Role;
import mx.edu.utez.firstapp.models.role.RoleRepository;
import mx.edu.utez.firstapp.models.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Configuration
public class InitialConfig implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final PersonRepository personRepository;
    private final UserRepository userRepository;

    public InitialConfig(RoleRepository roleRepository, PersonRepository personRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.personRepository = personRepository;
        this.userRepository = userRepository;
    }

    //Si sale bien, hace commit. Si sale mal marca error, pero no guarda nada
    @Override
    @Transactional(rollbackFor = {SQLException.class})
    public void run(String... args) throws Exception {
        Role adminRole = getOrSaveRole(new Role("ADMIN_ROLE"));
        getOrSaveRole(new Role("USER_ROLE"));
        getOrSaveRole(new Role("CLIENT_ROLE"));
    }

    @Transactional
    public Role getOrSaveRole(Role role){
        Optional<Role> foundRole = roleRepository.findByName(role.getName());
        return foundRole.orElseGet(()->roleRepository.saveAndFlush(role));
    }
}
