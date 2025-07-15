package exception.exception.utility;

//import jakarta.annotation.sql.DataSourceDefinition;
import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class Userdto {

    private Long id;
    private String name;
    private String email;
    private String phone;

}
