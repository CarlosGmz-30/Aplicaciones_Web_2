package mx.edu.utez.examen.controller;

import mx.edu.utez.examen.model.dto.DtoLibro;
import mx.edu.utez.examen.model.entity.LibroBean;
import mx.edu.utez.examen.service.ILibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libro")
public class LibroController {
    @Autowired
    private ILibro libroService;

    @PostMapping("/")
    public DtoLibro create(@RequestBody DtoLibro dtoLibro) {
        LibroBean libroSave = libroService.save(dtoLibro);
        return DtoLibro.builder()
                .id(libroSave.getId())
                .name(libroSave.getName())
                .ISBN(libroSave.getISBN())
                .author(libroSave.getAuthor())
                .page_number(libroSave.getPage_number())
                .category(libroSave.getCategory())
                .publication_date(libroSave.getPublication_date()).build();
    }

    @PutMapping("/")
    public DtoLibro update(@RequestBody DtoLibro dtoLibro) {
        LibroBean libroUpdate = libroService.save(dtoLibro);
        return DtoLibro.builder()
                .id(libroUpdate.getId())
                .name(libroUpdate.getName())
                .ISBN(libroUpdate.getISBN())
                .author(libroUpdate.getAuthor())
                .page_number(libroUpdate.getPage_number())
                .category(libroUpdate.getCategory())
                .publication_date(libroUpdate.getPublication_date()).build();
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        LibroBean libro = libroService.findById(id);
        libroService.delete(libro);
    }

    @GetMapping("/{id}")
    public LibroBean showById(@PathVariable Integer id) {
        return libroService.findById(id);
    }

    @GetMapping("/")
    public List<LibroBean> findAll() {
        return libroService.findAll();
    }
}

