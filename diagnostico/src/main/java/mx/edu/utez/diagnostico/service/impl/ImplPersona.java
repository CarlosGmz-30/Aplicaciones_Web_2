package mx.edu.utez.diagnostico.service.impl;

import mx.edu.utez.diagnostico.model.dao.DaoPersona;
import mx.edu.utez.diagnostico.model.dto.DtoPersona;
import mx.edu.utez.diagnostico.model.entity.personaBean;
import mx.edu.utez.diagnostico.service.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplPersona implements IPersona {

    @Autowired
    private DaoPersona daoPersona;

    @Transactional
    @Override
    public personaBean save(DtoPersona dtoPersona) {
        personaBean persona = personaBean.builder()
                .id(dtoPersona.getId())
                .name(dtoPersona.getName())
                .firstname(dtoPersona.getFirstname())
                .lastname(dtoPersona.getLastname())
                .age(dtoPersona.getAge()).build();
        return daoPersona.save(persona);
    }

    @Transactional(readOnly = true)
    @Override
    public personaBean findById(Integer id) {
        return daoPersona.findById(id).orElse(null);
    }

    @Override
    public void delete(personaBean persona) {
        daoPersona.delete(persona);
    }

    @Override
    public List<personaBean> findAll() {
        return (List<personaBean>) daoPersona.findAll();
    }
}
