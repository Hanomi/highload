package vera.ru.highload.service;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import vera.ru.highload.mapper.UserMapper;
import vera.ru.highload.model.UserDTO;
import vera.ru.highload.model.UserRegisterPost200ResponseDTO;
import vera.ru.highload.model.UserRegisterPostRequestDTO;
import vera.ru.highload.repository.UserRepository;

import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {

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
                .doOnNext(i -> System.out.println(i))
                .map(userMapper::toUserRegResponse);

    }

//    @Override
//    public Flux<UserDTO> findUserByName(String firstName, String lastName) {
//
//        return userRepository
//                .findAll()
//                .map(userMapper::userToDto);
//    }


}
