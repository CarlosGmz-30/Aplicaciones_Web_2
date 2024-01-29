package mx.edu.utez.examen.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@ToString
@Builder
public class DtoLibro {
    private Integer id;
    private String name;
    private String ISBN;
    private String author;
    private Long page_number;
    private String category;
    private String publication_date;
}
