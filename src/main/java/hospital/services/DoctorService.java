package hospital.services;

import hospital.domain.Doctor;
import hospital.repositories.DoctorRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lilit
 */
@Service
@Slf4j
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepo;

    public List<Doctor> findAll() {
        List<Doctor> foundDoctor = doctorRepo.findAll();
        return foundDoctor;
    }

    public Optional<Doctor> createDoctor(Doctor doctor) {
        final Doctor savedDoctor = doctorRepo.save(doctor);
        return Optional.ofNullable(savedDoctor);
    }

}
