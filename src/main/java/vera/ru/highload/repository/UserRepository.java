package vera.ru.highload.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import vera.ru.highload.model.User;

public interface UserRepository extends ReactiveCrudRepository<User, String> {

}
