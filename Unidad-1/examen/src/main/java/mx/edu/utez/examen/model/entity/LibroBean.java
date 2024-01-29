package mx.edu.utez.examen.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "libro")
public class LibroBean {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "ISBN", nullable = false)
    private String ISBN;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "page_number", nullable = false)
    private Long page_number;
    @Column(name = "category", nullable = false)
    private String category;
    @Column(name = "publication_date", nullable = false)
    private String publication_date;
    @Column(name = "folio", nullable = false, unique = true)
    private String folio;
}
