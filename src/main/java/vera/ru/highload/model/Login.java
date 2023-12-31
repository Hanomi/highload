package vera.ru.highload.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(schema = "mydbschema", name = "logins")
public class Login {

    @Id
    @Column("id")
    private UUID id;
    @Column("user_id")
    private UUID userId;

}

