package dev.patika.spring.api;

import dev.patika.spring.business.abstracts.IAppointmentService;
import dev.patika.spring.core.ResponseHandler;
import dev.patika.spring.model.dto.requests.AddAnimalRequest;
import dev.patika.spring.model.dto.requests.AddAppointmentRequest;
import dev.patika.spring.model.dto.requests.UpdateAnimalRequest;
import dev.patika.spring.model.dto.requests.UpdateAppointmentRequest;
import dev.patika.spring.model.dto.responses.GetAnimalResponse;
import dev.patika.spring.model.dto.responses.GetAppointmentResponse;
import dev.patika.spring.model.entity.Appointment;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/appointments")
@AllArgsConstructor
public class AppointmentController {

    private IAppointmentService appointmentService;

    @GetMapping()
    public ResponseEntity<Object> findAll(){
        return ResponseHandler
                .responseBuilder("Requested all appointments", HttpStatus.OK,appointmentService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id){
        Appointment data = appointmentService.findById(id);
        if(data!=null){
            return ResponseHandler
                    .responseBuilder("Requested all appointments", HttpStatus.OK,data);

        }
        return ResponseHandler
                .responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
    }

    // Değerlendirme formu 24
    @GetMapping("/search/doctor")
    public ResponseEntity<Object> findByDateAndDoctor(@RequestParam(value = "startDate") LocalDate startDate,@RequestParam(value = "endDate")  LocalDate endDate,@RequestParam(value = "doctorName") String doctorName){
        List<GetAppointmentResponse> data = appointmentService.findByBetweenDateAndDoctor(startDate, endDate, doctorName);
        if(data!=null){
            return ResponseHandler
                    .responseBuilder("Requested appointments", HttpStatus.OK,data);

        }
        return ResponseHandler
                .responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
    }

    // Değerlendirme formu 23
    @GetMapping("/search/animal")
    public ResponseEntity<Object> findByDateAndAnimal(@RequestParam(value = "startDate") LocalDate startDate,@RequestParam(value = "endDate")  LocalDate endDate,@RequestParam(value = "animalName") String animalName){
        List<GetAppointmentResponse> data = appointmentService.findByBetweenDateAndAnimal(startDate, endDate, animalName);
        if(data!=null){
            return ResponseHandler
                    .responseBuilder("Requested appointments", HttpStatus.OK,data);

        }
        return ResponseHandler
                .responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
    }

    // Değerlendirme formu 14
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody AddAppointmentRequest request){
        AddAppointmentRequest added = appointmentService.add(request);
        if(added!=null){
            return ResponseHandler.responseBuilder(
                    "Create a Appointment request",
                    HttpStatus.CREATED,
                    appointmentService.add(request)
            );
        }
        return ResponseHandler.responseBuilder(
                "ERROR: Doctor is not available at this date and time",
                HttpStatus.BAD_REQUEST
        );
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody UpdateAppointmentRequest request){
        UpdateAppointmentRequest update = appointmentService.update(request);
        if(update==null){
            return ResponseHandler.responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.responseBuilder(
                "Update Animal request",
                HttpStatus.OK,
                update
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        if(appointmentService.delete(id)){
            return ResponseHandler.responseBuilder("Delete request succeed", HttpStatus.OK);
        }
        return ResponseHandler.responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
    }

}
