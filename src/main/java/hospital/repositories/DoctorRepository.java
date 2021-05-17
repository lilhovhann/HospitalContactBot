package hospital.repositories;

import hospital.domain.Doctor;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author lilit
 */
@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {
        Optional<Doctor> findByName(String name);
 
}
