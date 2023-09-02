package vera.ru.highload.service;

import reactor.core.publisher.Mono;
import vera.ru.highload.model.LoginPost200ResponseDTO;
import vera.ru.highload.model.LoginPostRequestDTO;

public interface LoginService {

    Mono<LoginPost200ResponseDTO> login(Mono<LoginPostRequestDTO> loginPostRequestDTO);
}
