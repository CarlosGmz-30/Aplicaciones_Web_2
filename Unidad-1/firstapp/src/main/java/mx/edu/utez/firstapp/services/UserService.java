package mx.edu.utez.firstapp.services;

import mx.edu.utez.firstapp.config.ApiResponse;
import mx.edu.utez.firstapp.models.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAll() {
        return new ResponseEntity<>
                (new ApiResponse(repository.findAll(), HttpStatus.OK), HttpStatus.OK);
    }
}
