package hospital.services;

import hospital.domain.Doctor;
import hospital.dto.DoctorDTO;
import hospital.repositories.DoctorRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
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

    public Optional<Doctor> createDoctor(DoctorDTO doctorDto) {
        Doctor convertedData = convertEntityToDto(doctorDto);
        final Doctor savedDoctor = doctorRepo.save(convertedData);
        return Optional.ofNullable(savedDoctor);
    }
    
    public static DoctorDTO convertEntityToDto(Doctor doctor) {
        DoctorDTO doctorDTOResponse = new DoctorDTO();
        try {
            BeanUtils.copyProperties(doctor, doctorDTOResponse);
        } catch (BeansException e) {
            throw new RuntimeException("Error creating doctorDTO response from Doctor", e);
        }
        return doctorDTOResponse;
    }
    
     public static Doctor convertEntityToDto(DoctorDTO doctorDTO) {
        Doctor doctorResponse = new Doctor();
        try {
            BeanUtils.copyProperties(doctorDTO, doctorResponse);
        } catch (BeansException e) {
            throw new RuntimeException("Error creating doctor from DoctorDto", e);
        }
        return doctorResponse;
    }

}
