package mx.edu.utez.diagnostico.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Builder
public class DtoPersona {
    private Integer id;
    private String name;
    private String firstname;
    private String lastname;
    private Integer age;
}
