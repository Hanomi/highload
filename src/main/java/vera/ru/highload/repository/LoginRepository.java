package vera.ru.highload.repository;


import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;
import vera.ru.highload.model.Login;

import java.util.UUID;

public interface LoginRepository extends Repository<Login, UUID> {

    @Modifying
    @Transactional
    @Query("""
            DELETE
            FROM mydbschema.logins l
            WHERE l.user_id = :userId
            """)
    void deleteLoginByUserId(UUID userId);

    @Transactional
    @Query("""
            INSERT INTO mydbschema.logins (user_id)
            VALUES (:#{#login.userId})
            RETURNING id, user_id
            """)
    Login save(Login login);

}
