package vera.ru.highload.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vera.ru.highload.model.User;
import vera.ru.highload.model.UserDTO;
import vera.ru.highload.model.UserRegisterPost200ResponseDTO;
import vera.ru.highload.model.UserRegisterPostRequestDTO;

@Mapper(componentModel = "Spring")
public interface UserMapper {

    UserDTO userToDto(User user);
    User userRequestToUser(UserRegisterPostRequestDTO user);

    @Mapping(source = "id",  target = "userId")
    UserRegisterPost200ResponseDTO toUserRegResponse(User user);

}
