package hospital.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author lilith
 */
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "doctors")
public class Doctor implements Serializable {

    private static final long serialVersionUID = 5457306871064654513L;

    @Id
    private String id;
    
    private String name;
    private String proffession;
    private String phone;

}
