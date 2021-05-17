package hospital.repositories;

import hospital.domain.Doctor;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author lilit
 */
@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {

 
}
