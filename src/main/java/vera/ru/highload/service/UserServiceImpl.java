package vera.ru.highload.service;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import vera.ru.highload.mapper.UserMapper;
import vera.ru.highload.model.UserDTO;
import vera.ru.highload.repository.UserRepository;

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
    public Flux<UserDTO> findUserByName(String firstName, String lastName) {

        return userRepository
                .findAll()
                .map(userMapper::userToDto);
    }
}
