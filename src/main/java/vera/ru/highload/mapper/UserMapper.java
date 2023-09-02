package vera.ru.highload.mapper;

import org.mapstruct.Mapper;
import vera.ru.highload.model.User;
import vera.ru.highload.model.UserDTO;

@Mapper(componentModel = "Spring")
public interface UserMapper {

    UserDTO userToDto(User user);

}
