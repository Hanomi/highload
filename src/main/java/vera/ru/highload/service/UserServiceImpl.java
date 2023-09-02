package vera.ru.highload.service;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import vera.ru.highload.mapper.UserMapper;
import vera.ru.highload.model.*;
import vera.ru.highload.repository.UserRepository;

import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {

    private final Argon2PasswordEncoder encoder = new Argon2PasswordEncoder(32,64,1,15*1024,2);
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(
            UserRepository userRepository,
            UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Mono<UserDTO> getUserById(String id) {
        return Mono.just(id)
                .map(UUID::fromString)
                .flatMap(userRepository::findById)
                .map(userMapper::userToDto);
    }

    @Override
    public Mono<UserRegisterPost200ResponseDTO> registryUser(Mono<UserRegisterPostRequestDTO> userRegisterPostRequestDTO) {

        return userRegisterPostRequestDTO
                .map(userMapper::userRequestToUser)
                .flatMap(userRepository::save)
                .map(userMapper::toUserRegResponse);

    }

    @Override
    public Mono<User> findByIdAndPassword(Mono<LoginPostRequestDTO> r) {
        return r.map(userMapper::loginRequestToUser)
                .flatMap(u -> userRepository
                        .findById(u.getId())
                        .filter(i -> encoder.matches(u.getPassword(), i.getPassword())));
    }
}
