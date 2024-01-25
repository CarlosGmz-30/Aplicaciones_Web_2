package mx.edu.utez.firstapp.controllers.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class SignDto {
    private String username;
    private String password;
}
