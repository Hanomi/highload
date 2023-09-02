package vera.ru.highload.service;

import reactor.core.publisher.Mono;
import vera.ru.highload.model.*;

public interface UserService {

    Mono<UserDTO> getUserById(String id);

    Mono<UserRegisterPost200ResponseDTO> registryUser(Mono<UserRegisterPostRequestDTO> userRegisterPostRequestDTO);

    //todo dublicate?
    Mono<User> findByIdAndPassword(Mono<LoginPostRequestDTO> login);
}
