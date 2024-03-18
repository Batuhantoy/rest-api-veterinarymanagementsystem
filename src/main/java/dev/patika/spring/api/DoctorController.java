package dev.patika.spring.api;

import dev.patika.spring.business.abstracts.IDoctorService;
import dev.patika.spring.core.ResponseHandler;
import dev.patika.spring.model.dto.requests.AddDoctorRequest;
import dev.patika.spring.model.dto.requests.UpdateDoctorRequest;
import dev.patika.spring.model.dto.responses.GetDoctorResponse;
import dev.patika.spring.model.entity.Doctor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/doctors")
@AllArgsConstructor
public class DoctorController {

    private IDoctorService doctorService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> findAll(){
        return ResponseHandler
                .responseBuilder("Requested all doctors", HttpStatus.OK,doctorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id){
        Doctor data = doctorService.findById(id);
        if(data!=null){
            return ResponseHandler
                    .responseBuilder("Requested Doctor by Id", HttpStatus.OK,data);
        }
        return ResponseHandler
                .responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
    }

    // Değerlendirme formu 12
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody AddDoctorRequest request){
        return ResponseHandler.responseBuilder(
                "Create a Doctor request",
                HttpStatus.CREATED,
                doctorService.add(request)
        );
    }
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody UpdateDoctorRequest request){
        UpdateDoctorRequest update = doctorService.update(request);
        if(update==null){
            return ResponseHandler.responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.responseBuilder(
                "Update Doctor request",
                HttpStatus.OK,
                doctorService.update(request)
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        if(doctorService.delete(id)){
            return ResponseHandler.responseBuilder("Delete request succeed", HttpStatus.OK);
        }
        return ResponseHandler.responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
    }

}
