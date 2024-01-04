package mx.edu.utez.diagnostico.model.dao;

import mx.edu.utez.diagnostico.model.entity.personaBean;
import org.springframework.data.repository.CrudRepository;

public interface DaoPersona extends CrudRepository<personaBean, Integer> {
}
