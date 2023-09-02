package vera.ru.highload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vera.ru.highload.model.UserDTO;
import vera.ru.highload.model.UserRegisterPost200ResponseDTO;
import vera.ru.highload.model.UserRegisterPostRequestDTO;
import vera.ru.highload.service.UserService;

@RestController
@Slf4j
public class UserController implements UserApi {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @Override
//    public Mono<ResponseEntity<Flux<UserDTO>>> userSearchGet(String firstName, String lastName, ServerWebExchange exchange) {
//
//        Flux<UserDTO> all = userService.findUserByName(firstName, lastName);
//
//        return Mono.just(ResponseEntity
//                .status(HttpStatus.OK)
//                .body(all));
//    }


    @Override
    public Mono<ResponseEntity<UserDTO>> userGetIdGet(String id, ServerWebExchange exchange) {

        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()))
                .onErrorResume(e -> e.getClass() == java.lang.IllegalArgumentException.class,error -> {
                    log.error("ошибка запроса", error);
                    return Mono.just(ResponseEntity.badRequest().build());
                });
    }

    @Override
    public Mono<ResponseEntity<UserRegisterPost200ResponseDTO>> userRegisterPost(Mono<UserRegisterPostRequestDTO> userRegisterPostRequestDTO, ServerWebExchange exchange) {
        //          @ApiResponse(responseCode = "200", description = "Успешная регистрация", content = {
        //                @Content(mediaType = "application/json", schema = @Schema(implementation = UserRegisterPost200ResponseDTO.class))
        //            }),
        //            @ApiResponse(responseCode = "400", description = "Невалидные данные"),
        //            @ApiResponse(responseCode = "500", description = "Ошибка сервера", content = {
        //                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500ResponseDTO.class))
        //            }),
        //            @ApiResponse(responseCode = "503", description = "Ошибка сервера", content = {
        //                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500ResponseDTO.class))
        //            })

        return userService.registryUser(userRegisterPostRequestDTO)
                .map(ResponseEntity::ok);
    }
}
