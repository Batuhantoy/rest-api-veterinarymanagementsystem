package dev.patika.spring.api;

import dev.patika.spring.business.abstracts.IAvailableDateService;
import dev.patika.spring.core.ResponseHandler;
import dev.patika.spring.model.dto.requests.AddAvailableDateRequest;
import dev.patika.spring.model.dto.requests.AddCustomerRequest;
import dev.patika.spring.model.dto.requests.UpdateAvailableDateRequest;
import dev.patika.spring.model.dto.requests.UpdateCustomerRequest;
import dev.patika.spring.model.dto.responses.GetAppointmentResponse;
import dev.patika.spring.model.dto.responses.GetAvailableDateResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/availabledates")
@AllArgsConstructor
public class AvailableDateController {

    private IAvailableDateService service;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> findAll(){
        return ResponseHandler
                .responseBuilder("Requested all available dates", HttpStatus.OK,service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id){
        GetAvailableDateResponse data = service.findById(id);
        if(data!=null){
            return ResponseHandler
                    .responseBuilder("Requested AvailableDate by Id", HttpStatus.OK,data);
        }
        return ResponseHandler
                .responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody AddAvailableDateRequest request){
        return ResponseHandler.responseBuilder(
                "Create a Customer request",
                HttpStatus.CREATED,
                service.add(request)
        );
    }
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody UpdateAvailableDateRequest request){
        UpdateAvailableDateRequest update = service.update(request);
        if(update==null){
            return ResponseHandler.responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.responseBuilder(
                "Update AvailableDate request",
                HttpStatus.OK,
                service.update(request)
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        if(service.delete(id)){
            return ResponseHandler.responseBuilder("Delete request succeed", HttpStatus.OK);
        }
        return ResponseHandler.responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
    }
}
