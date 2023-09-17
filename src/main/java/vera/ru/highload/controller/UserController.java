package vera.ru.highload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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

    @Override
    public ResponseEntity<UserDTO> userGetIdGet(String id) {
        var user = userService.getUserById(id);

        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<UserRegisterPost200ResponseDTO> userRegisterPost(UserRegisterPostRequestDTO userRegisterPostRequestDTO) {

        var registeredUser = userService.registryUser(userRegisterPostRequestDTO);

        return ResponseEntity.ok(registeredUser);
    }
}
