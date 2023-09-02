package vera.ru.highload.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import vera.ru.highload.model.Login;

import java.util.UUID;

public interface LoginRepository extends ReactiveCrudRepository<Login, UUID> {

}
