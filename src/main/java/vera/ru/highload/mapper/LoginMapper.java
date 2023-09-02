package vera.ru.highload.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vera.ru.highload.model.Login;
import vera.ru.highload.model.LoginPost200ResponseDTO;
import vera.ru.highload.model.LoginPostRequestDTO;
import vera.ru.highload.model.User;

@Mapper(componentModel = "Spring")
public interface LoginMapper {

    default Login userToLogin(User user) {
        return Login.builder().userId(user.getId()).build();
    }

    @Mapping(source = "id", target = "token")
    LoginPost200ResponseDTO loginToResponse(Login login);
}
