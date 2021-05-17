package hospital.controllers;

import hospital.domain.Doctor;
import hospital.dto.DoctorDTO;
import hospital.services.DoctorService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
 
    @GetMapping(path = "/find/All", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        List<Doctor> savedDoctor = doctorService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(savedDoctor);
    }
    
     @GetMapping(path = "/find/by/name", produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity findByName(String name) {
        Optional<Doctor> savedDoctor = doctorService.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(savedDoctor.get());
    }
}
