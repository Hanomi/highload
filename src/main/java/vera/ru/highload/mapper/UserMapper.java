package vera.ru.highload.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import vera.ru.highload.model.*;

@Mapper(componentModel = "Spring")
public interface UserMapper {

    UserDTO userToDto(User user);

    User userRequestToUser(UserRegisterPostRequestDTO user);

    User loginRequestToUser(LoginPostRequestDTO loginPostRequestDTO);

    @Mapping(source = "id",  target = "userId")
    UserRegisterPost200ResponseDTO toUserRegResponse(User user);

}
