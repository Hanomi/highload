package vera.ru.highload.service;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import vera.ru.highload.mapper.LoginMapper;
import vera.ru.highload.mapper.UserMapper;
import vera.ru.highload.model.LoginPost200ResponseDTO;
import vera.ru.highload.model.LoginPostRequestDTO;
import vera.ru.highload.repository.LoginRepository;

import java.util.UUID;

@Component
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;
    private final LoginMapper loginMapper;

    private final UserService userService;

    public LoginServiceImpl(
            LoginRepository loginRepository,
            LoginMapper loginMapper,
            UserService userService,
            UserMapper userMapper) {
        this.loginRepository = loginRepository;
        this.loginMapper = loginMapper;
        this.userService = userService;
    }

    @Override
    public Mono<LoginPost200ResponseDTO> login(Mono<LoginPostRequestDTO> loginPostRequestDTO) {

       return userService.findByIdAndPassword(loginPostRequestDTO)
                .map(loginMapper::userToLogin)
                .flatMap(loginRepository::save)
                .map(loginMapper::loginToResponse);
    }
}

