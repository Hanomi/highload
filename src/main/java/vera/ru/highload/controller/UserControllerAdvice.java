package vera.ru.highload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vera.ru.highload.model.LoginPost500ResponseDTO;

@Slf4j
@RestControllerAdvice(assignableTypes = UserController.class)
public class UserControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<LoginPost500ResponseDTO> handleException(Exception ex) {
        var status = HttpStatus.I_AM_A_TEAPOT;

        var errorResponse = LoginPost500ResponseDTO.builder()
                .message("")
                .code(500)
                .requestId("")
                .build();

        log.error("Exception has been occurred", ex);

        return new ResponseEntity<>(errorResponse, status);
    }

}
