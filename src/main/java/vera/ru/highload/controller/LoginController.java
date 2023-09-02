package vera.ru.highload.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import vera.ru.highload.model.LoginPost200ResponseDTO;
import vera.ru.highload.model.LoginPostRequestDTO;
import vera.ru.highload.service.LoginService;

@RestController
public class LoginController implements LoginApi {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public Mono<ResponseEntity<LoginPost200ResponseDTO>> loginPost(Mono<LoginPostRequestDTO> loginPostRequestDTO, ServerWebExchange exchange) {
        //           @ApiResponse(responseCode = "200", description = "Успешная аутентификация", content = {
        //                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost200ResponseDTO.class))
        //            }),
        //            @ApiResponse(responseCode = "400", description = "Невалидные данные"),
        //            @ApiResponse(responseCode = "404", description = "Пользователь не найден"),
        //            @ApiResponse(responseCode = "500", description = "Ошибка сервера", content = {
        //                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500ResponseDTO.class))
        //            }),
        //            @ApiResponse(responseCode = "503", description = "Ошибка сервера", content = {
        //                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500ResponseDTO.class))
        //            })

        return loginService.login(loginPostRequestDTO)
                .map(ResponseEntity::ok);
    }
}
