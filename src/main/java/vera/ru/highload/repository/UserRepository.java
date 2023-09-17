package vera.ru.highload.repository;


import org.springframework.data.jdbc.repository.query.Query;

import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;
import vera.ru.highload.model.Login;
import vera.ru.highload.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends Repository<User, UUID> {

    @Query("""
            select id, password
            from mydbschema.users
            where id = :id
            """)
    Optional<User> grepIdAndPasswordById(UUID id);

    @Query("""
            select id, first_name, second_name, age, birthdate, biography, city
            from mydbschema.users
            where id = :id
            """)
    Optional<User> findById(UUID id);

    @Transactional
    @Query("""
            INSERT INTO mydbschema.users(first_name, second_name, age, birthdate, city, biography, password)
            VALUES (:#{#user.firstName}, :#{#user.secondName}, :#{#user.age}, :#{#user.birthdate}, :#{#user.city},
                    :#{#user.biography}, :#{#user.password})
            RETURNING id, first_name, second_name, age, birthdate, city, biography, password
            """)
    User save(User user);
}
