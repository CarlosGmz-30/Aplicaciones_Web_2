package mx.edu.utez.diagnostico.controller;

import mx.edu.utez.diagnostico.model.dto.DtoPersona;
import mx.edu.utez.diagnostico.model.entity.personaBean;
import mx.edu.utez.diagnostico.service.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/persona")
public class personaController {
    @Autowired
    private IPersona personaService;

    @PostMapping("/")
    public DtoPersona create(@RequestBody DtoPersona dtoPersona) {
        personaBean personaSave = personaService.save(dtoPersona);
        return DtoPersona.builder()
                .id(personaSave.getId())
                .name(personaSave.getName())
                .firstname(personaSave.getFirstname())
                .lastname(personaSave.getLastname())
                .age(personaSave.getAge()).build();
    }

    @PutMapping("/")
    public DtoPersona update(@RequestBody DtoPersona dtoPersona) {
        personaBean personaUpdate = personaService.save(dtoPersona);
        return DtoPersona.builder()
                .id(personaUpdate.getId())
                .name(personaUpdate.getName())
                .firstname(personaUpdate.getFirstname())
                .lastname(personaUpdate.getLastname())
                .age(personaUpdate.getAge()).build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        personaBean persona = personaService.findById(id);
        personaService.delete(persona);
    }

    @GetMapping("/{id}")
    public personaBean showById(@PathVariable Integer id) {
        return personaService.findById(id);
    }

    @GetMapping("/")
    public List<personaBean> findAll() {
        return personaService.findAll();
    }
}
