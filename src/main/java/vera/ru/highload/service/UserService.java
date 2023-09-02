package vera.ru.highload.service;

import reactor.core.publisher.Flux;
import vera.ru.highload.model.UserDTO;

public interface UserService {

    Flux<UserDTO> findUserByName(String firstName, String lastName);

}
