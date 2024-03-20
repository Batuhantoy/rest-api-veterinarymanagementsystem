package dev.patika.spring.api;

import dev.patika.spring.business.abstracts.IAnimalService;
import dev.patika.spring.core.ResponseHandler;
import dev.patika.spring.model.dto.requests.AddAnimalRequest;
import dev.patika.spring.model.dto.requests.UpdateAnimalRequest;
import dev.patika.spring.model.dto.requests.UpdateCustomerRequest;
import dev.patika.spring.model.dto.responses.GetAnimalResponse;
import dev.patika.spring.model.entity.Animal;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/animals")
@AllArgsConstructor
public class AnimalController {

    private IAnimalService animalService;

    @GetMapping()
    public ResponseEntity<Object> findAll(){
        return ResponseHandler
                .responseBuilder("Requested all animals", HttpStatus.OK,animalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id){
        Animal data = animalService.findById(id);
        if(data!=null){
            return ResponseHandler
                    .responseBuilder("Requested animal by Id", HttpStatus.OK,data);

        }
        return ResponseHandler
                .responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
    }

    // Değerlendirme formu 16
    @GetMapping("/search")
    public ResponseEntity<Object> findByNameLike(@RequestParam("name") String name){
        return ResponseHandler
                .responseBuilder("Request by Name", HttpStatus.OK,animalService.findByNameLike(name));
    }

    // Değerlendirme formu 18
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Object> findByCustomer(@PathVariable("customerId") Long id){
        List<Animal> data = animalService.findByCustomer(id);
        if(!data.isEmpty()){
            return ResponseHandler
                    .responseBuilder("Request Animals by Customer", HttpStatus.OK,data);
        }
        return ResponseHandler
                .responseBuilder("ERROR: No such Customer", HttpStatus.BAD_REQUEST);
    }


    // Değerlendirme formu 11
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody AddAnimalRequest request){
        return ResponseHandler.responseBuilder(
                "Create a Animal request",
                HttpStatus.CREATED,
                animalService.add(request)
        );
    }
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody UpdateAnimalRequest request){
        UpdateAnimalRequest update = animalService.update(request);
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
        if(animalService.delete(id)){
            return ResponseHandler.responseBuilder("Delete request succeed", HttpStatus.OK);
        }
        return ResponseHandler.responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
    }

}
