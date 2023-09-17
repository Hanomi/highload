package vera.ru.highload.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Component;

import org.springframework.web.server.ResponseStatusException;
import vera.ru.highload.mapper.UserMapper;
import vera.ru.highload.model.*;
import vera.ru.highload.repository.UserRepository;

import java.util.Optional;
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
    public Optional<UserDTO> getUserById(String id) {

        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Невалидные данные");
        }
        var user = userRepository.findById(uuid);

        return user.map(userMapper::userToDto);
    }

    @Override
    public UserRegisterPost200ResponseDTO registryUser(UserRegisterPostRequestDTO userRegisterPostRequestDTO) {

        var user = userMapper.userRequestToUser(userRegisterPostRequestDTO);
        user.setPassword(encoder.encode(user.getPassword()));
        var savedUser = userRepository.save(user);

        return userMapper.toUserRegResponse(savedUser);
    }

    @Override
    public Optional<User> findByIdAndPassword(LoginPostRequestDTO r) {

        User user;

        try {
            user = userMapper.loginRequestToUser(r);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Невалидные данные");
        }

        return userRepository.grepIdAndPasswordById(user.getId())
                .filter(i -> encoder.matches(r.getPassword(), i.getPassword()));
    }
}
