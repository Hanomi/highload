package vera.ru.highload.service;

import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vera.ru.highload.model.User;
import vera.ru.highload.model.UserDTO;
import vera.ru.highload.model.UserRegisterPost200ResponseDTO;
import vera.ru.highload.model.UserRegisterPostRequestDTO;

public interface UserService {

    Mono<UserDTO> getUserById(String id);

    Mono<UserRegisterPost200ResponseDTO> registryUser(Mono<UserRegisterPostRequestDTO> userRegisterPostRequestDTO);

    Mono<User> findByIdAndPassword(User r);
}
