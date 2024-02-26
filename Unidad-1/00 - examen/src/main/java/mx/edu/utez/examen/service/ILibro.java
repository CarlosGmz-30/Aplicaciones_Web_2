package mx.edu.utez.examen.service;

import mx.edu.utez.examen.model.dto.DtoLibro;
import mx.edu.utez.examen.model.entity.LibroBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ILibro {
    LibroBean save(DtoLibro libro);

    LibroBean findById(Integer id);

    // LibroBean findByFolio(String Folio);

    void delete(LibroBean libro);

    @Transactional(readOnly = true)
    List<LibroBean> findAll();
}
