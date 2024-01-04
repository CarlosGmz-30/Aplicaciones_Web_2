package mx.edu.utez.diagnostico.service;

import mx.edu.utez.diagnostico.model.dto.DtoPersona;
import mx.edu.utez.diagnostico.model.entity.personaBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IPersona {
    personaBean save(DtoPersona persona);

    personaBean findById(Integer id);

    void delete(personaBean persona);

    @Transactional(readOnly = true)
    List<personaBean> findAll();
}
