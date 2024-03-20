package dev.patika.spring.api;

import dev.patika.spring.business.abstracts.IVaccineService;
import dev.patika.spring.core.ResponseHandler;
import dev.patika.spring.model.dto.requests.AddCustomerRequest;
import dev.patika.spring.model.dto.requests.AddVaccineRequest;
import dev.patika.spring.model.dto.requests.UpdateCustomerRequest;
import dev.patika.spring.model.dto.requests.UpdateVaccineRequest;
import dev.patika.spring.model.dto.responses.GetAvailableDateResponse;
import dev.patika.spring.model.dto.responses.GetVaccineResponse;
import dev.patika.spring.model.entity.Vaccine;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/vaccines")
@AllArgsConstructor
public class VaccineController {

    private IVaccineService vaccineService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> findAll(){
        return ResponseHandler
                .responseBuilder("Requested all vaccines", HttpStatus.OK,vaccineService.findAll());
    }

    // Değerlendirme formu 20
    @GetMapping("/search/{animalId}")
    public ResponseEntity<Object> findByAnimalId(@PathVariable("animalId") Long id){
        List<Vaccine> data = vaccineService.findByAnimalId(id);
        if(data!=null){
            return ResponseHandler
                    .responseBuilder("Requested Vaccines by Animal Id", HttpStatus.OK,data);
        }
        return ResponseHandler
                .responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id){
        Vaccine data = vaccineService.findById(id);
        if(data!=null){
            return ResponseHandler
                    .responseBuilder("Requested Vaccine by Id", HttpStatus.OK,data);
        }
        return ResponseHandler
                .responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
    }

    // Değerlendirme formu 21
    @GetMapping("/search")
    public ResponseEntity<Object> findByDates(@RequestParam(value = "startDate")  LocalDate startDate,@RequestParam(value="endDate") LocalDate endDate){
        List<Vaccine> data = vaccineService.findByDates(startDate, endDate);
        if(data!=null){
            return ResponseHandler
                    .responseBuilder("Requested Vaccines by Dates", HttpStatus.OK,data);
        }
        return ResponseHandler
                .responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/byName")
    @ResponseStatus(HttpStatus.OK)
    public List<Vaccine> findByName(@RequestParam String name) {
        return vaccineService.findByName(name);
    }

    // Değerlendirme formu 15
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody AddVaccineRequest request){
        AddVaccineRequest data = vaccineService.add(request);
        if(data!=null){
            return ResponseHandler.responseBuilder(
                    "Create a Vaccine request",
                    HttpStatus.CREATED,
                    data
            );
        }
        return ResponseHandler.responseBuilder(
                "ERROR: Same Vaccine is already protecting the animal",
                HttpStatus.BAD_REQUEST
        );
    }
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody UpdateVaccineRequest request){
        UpdateVaccineRequest update = vaccineService.update(request);
        if(update!=null){
            return ResponseHandler.responseBuilder(
                    "Update Vaccine request",
                    HttpStatus.OK,
                    update
            );
        }
        return ResponseHandler
                .responseBuilder("ERROR: No such Element or Vaccine Still Protects", HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        if(vaccineService.delete(id)){
            return ResponseHandler.responseBuilder("Delete request succeed", HttpStatus.OK);
        }
        return ResponseHandler.responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
    }
}
