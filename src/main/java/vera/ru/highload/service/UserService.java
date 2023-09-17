package vera.ru.highload.service;


import vera.ru.highload.model.*;

import java.util.Optional;

public interface UserService {

    Optional<UserDTO> getUserById(String id);

    UserRegisterPost200ResponseDTO registryUser(UserRegisterPostRequestDTO userRegisterPostRequestDTO);

    Optional<User> findByIdAndPassword(LoginPostRequestDTO login);
}
