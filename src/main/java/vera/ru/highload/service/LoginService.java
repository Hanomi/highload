package vera.ru.highload.service;

import vera.ru.highload.model.LoginPost200ResponseDTO;
import vera.ru.highload.model.LoginPostRequestDTO;

public interface LoginService {

    LoginPost200ResponseDTO login(LoginPostRequestDTO request);
}
