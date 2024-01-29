package mx.edu.utez.examen.service.Impl;

import mx.edu.utez.examen.model.dao.DaoLibro;
import mx.edu.utez.examen.model.dto.DtoLibro;
import mx.edu.utez.examen.model.entity.LibroBean;
import mx.edu.utez.examen.service.ILibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ImplLibro implements ILibro {
    @Autowired
    private DaoLibro daoLibro;


    private String generarFolio(DtoLibro dtoLibro) {
        char primeraLetraTitulo = dtoLibro.getName().charAt(0);
        char primeraLetraAutor = dtoLibro.getAuthor().charAt(0);
        String apellidoAutor = dtoLibro.getAuthor().substring(1);
        String dosLetrasApellido =(apellidoAutor.length() >= 2 ? apellidoAutor.substring(1, 3) : apellidoAutor).toUpperCase();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String fechaPublicacion = dateFormat.format(Date.parse(dtoLibro.getPublication_date()));
        String cuatroLetrasISBN = dtoLibro.getISBN().length() >= 4 ? dtoLibro.getISBN().substring(0, 4) : dtoLibro.getISBN();
        Random random = new Random();
        String dosDigitosAleatorios = String.format("%02d", random.nextInt(100));
        return String.format("%c%c%s%s%s%s", primeraLetraTitulo, primeraLetraAutor,
                dosLetrasApellido, fechaPublicacion, cuatroLetrasISBN, dosDigitosAleatorios);
    }

    @Override
    public LibroBean save(DtoLibro dtoLibro) {
        String folio = generarFolio(dtoLibro);
        LibroBean libro = LibroBean.builder().id(dtoLibro.getId())
                .name(dtoLibro.getName())
                .ISBN(dtoLibro.getISBN())
                .author(dtoLibro.getAuthor())
                .page_number(dtoLibro.getPage_number())
                .category(dtoLibro.getCategory())
                .publication_date(dtoLibro.getPublication_date())
                .folio(folio)
                .build();
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
