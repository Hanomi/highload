package vera.ru.highload.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vera.ru.highload.model.UserDTO;
import vera.ru.highload.service.UserService;

@RestController
public class UserController implements UserApi {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Mono<ResponseEntity<Flux<UserDTO>>> userSearchGet(String firstName, String lastName, ServerWebExchange exchange) {

        Flux<UserDTO> all = userService.findUserByName(firstName, lastName);

        return Mono.just(ResponseEntity
                .status(HttpStatus.OK)
                .body(all));
    }
}
