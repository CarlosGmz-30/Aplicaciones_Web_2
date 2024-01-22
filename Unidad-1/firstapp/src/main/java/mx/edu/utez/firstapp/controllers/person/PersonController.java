package mx.edu.utez.firstapp.controllers.person;

import jakarta.validation.Valid;
import mx.edu.utez.firstapp.config.ApiResponse;
import mx.edu.utez.firstapp.controllers.person.dto.PersonDto;
import mx.edu.utez.firstapp.services.person.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAll() {
        return service.getAll();
    }


    @PostMapping("/")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody PersonDto personDto) {
        return service.save(personDto.toEntity());
    }
}