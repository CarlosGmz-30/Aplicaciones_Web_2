package mx.edu.utez.examen.model.dao;

import mx.edu.utez.examen.model.entity.LibroBean;
import org.springframework.data.repository.CrudRepository;

public interface DaoLibro extends CrudRepository<LibroBean, Integer> {
}
