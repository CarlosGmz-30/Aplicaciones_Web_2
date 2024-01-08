package mx.edu.utez.firstapp.models.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // MethodQueris -> findById
    Optional<Role> findByName(String name);

}