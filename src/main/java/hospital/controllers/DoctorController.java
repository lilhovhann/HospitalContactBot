package hospital.controllers;

import hospital.domain.Doctor;
import hospital.dto.DoctorDTO;
import hospital.services.DoctorService;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author lilit
 */
@RestController
@RequestMapping("/api/v2/doctors")
@Slf4j
public class DoctorController {
 
    @Autowired
    private DoctorService doctorService;

    @PostMapping(path = "/creation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody DoctorDTO doctorDto) {
        log.info("Create doctor " + doctorDto.toString());

        Optional<Doctor> savedDoctor = doctorService.createDoctor(doctorDto);
        return ResponseEntity.status(HttpStatus.OK).body(savedDoctor.get());
    }

}
