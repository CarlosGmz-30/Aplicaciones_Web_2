package mx.edu.utez.examen.service.Impl;

import mx.edu.utez.examen.model.dao.DaoLibro;
import mx.edu.utez.examen.model.dto.DtoLibro;
import mx.edu.utez.examen.model.entity.LibroBean;
import mx.edu.utez.examen.service.ILibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplLibro implements ILibro {
    @Autowired
    private DaoLibro daoLibro;

    @Override
    public LibroBean save(DtoLibro dtoLibro) {
        LibroBean libro = LibroBean.builder().id(dtoLibro.getId())
                .name(dtoLibro.getName())
                .ISBN(dtoLibro.getISBN())
                .author(dtoLibro.getAuthor())
                .page_number(dtoLibro.getPage_number())
                .category(dtoLibro.getCategory())
                .publication_date(dtoLibro.getPublication_date()).build();
        return daoLibro.save(libro);
    }

    @Transactional(readOnly = true)
    @Override
    public LibroBean findById(Integer id) {
        return daoLibro.findById(id).orElse(null);
    }

    @Override
    public void delete(LibroBean libro) {
        daoLibro.delete(libro);
    }

    @Override
    public List<LibroBean> findAll() {
        return (List<LibroBean>) daoLibro.findAll();
    }

}
