package vera.ru.highload.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import vera.ru.highload.model.User;

import java.util.UUID;

public interface UserRepository extends ReactiveCrudRepository<User, UUID> {

}
