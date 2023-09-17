package vera.ru.highload.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<LoginPost200ResponseDTO> loginPost(LoginPostRequestDTO request) {

        var login = loginService.login(request);

        return ResponseEntity.ok(login);
    }
}
