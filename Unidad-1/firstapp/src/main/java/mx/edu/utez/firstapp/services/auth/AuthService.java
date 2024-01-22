package mx.edu.utez.firstapp.services.auth;

import mx.edu.utez.firstapp.config.ApiResponse;
import mx.edu.utez.firstapp.models.user.User;
import mx.edu.utez.firstapp.security.jxt.JwtProvider;
import mx.edu.utez.firstapp.services.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Transactional
public class AuthService {
    private final UserService userService;
    private final JwtProvider provider;
    private final AuthenticationManager manager;
    private final String PREFIX = "Bearer";

    public AuthService(UserService userService, JwtProvider provider, AuthenticationManager manager) {
        this.userService = userService;
        this.provider = provider;
        this.manager = manager;
    }

    @Transactional
    public ResponseEntity<ApiResponse> signIn(String username, String password) {
        try {
            Optional<User> foundUser = userService.findUserByUsername(username);
            if (foundUser.isEmpty())
                return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "UserNotFound"), HttpStatus.BAD_REQUEST);
            User user = foundUser.get();
            if (!user.getStatus())
                return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "UserNotEnable"), HttpStatus.BAD_REQUEST);
            if (!user.getBlocked())
                return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "UserBlocked"), HttpStatus.BAD_REQUEST);
            Authentication auth = manager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
            String token = provider.genereteToken(auth);
            // Payload - DTO (token, attrs)
            return new ResponseEntity<>(new ApiResponse(token, HttpStatus.OK), HttpStatus.OK);
        } catch (Exception e) {
            String message = "CredentialsMismatch";
            if (e instanceof DisabledException)
                message = "UserDisable";
            return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, message), HttpStatus.UNAUTHORIZED);
        }
    }
}
