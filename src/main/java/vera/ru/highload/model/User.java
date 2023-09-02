package vera.ru.highload.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

/**
 * UserDTO
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(schema = "mydbschema", name = "users")
public class User {

    @Id
    private UUID id;
    @Column("FIRSTNAME")
    private String firstName;
    @Column("SECONDNAME")
    private String secondName;
    private Integer age;
    private LocalDate birthdate;
    private String biography;
    private String city;

}

