package vera.ru.highload.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import vera.ru.highload.mapper.LoginMapper;
import vera.ru.highload.model.LoginPost200ResponseDTO;
import vera.ru.highload.model.LoginPostRequestDTO;
import vera.ru.highload.repository.LoginRepository;


@Component
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;
    private final LoginMapper loginMapper;
    private final UserService userService;

    public LoginServiceImpl(
            LoginRepository loginRepository,
            LoginMapper loginMapper,
            UserService userService) {
        this.loginRepository = loginRepository;
        this.loginMapper = loginMapper;
        this.userService = userService;
    }

    @Override
    public LoginPost200ResponseDTO login(LoginPostRequestDTO request) {

        var user = userService.findByIdAndPassword(request)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователь не найден"));

        loginRepository.deleteLoginByUserId(user.getId());

        var login = loginRepository.save(loginMapper.userToLogin(user));

        return loginMapper.loginToResponse(login);
    }
}

