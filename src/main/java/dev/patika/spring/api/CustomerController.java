package dev.patika.spring.api;

import dev.patika.spring.business.abstracts.ICustomerService;
import dev.patika.spring.core.ResponseHandler;
import dev.patika.spring.model.dto.requests.AddCustomerRequest;
import dev.patika.spring.model.dto.requests.UpdateCustomerRequest;
import dev.patika.spring.model.dto.responses.GetCustomerResponse;
import dev.patika.spring.model.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customers")
@AllArgsConstructor
public class CustomerController {
    private ICustomerService customerService;

    @GetMapping()
    public ResponseEntity<Object> findAll(){
        return ResponseHandler
                .responseBuilder("Requested all customers", HttpStatus.OK,customerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id){
        Customer data = customerService.findById(id);
        if(data!=null){
            return ResponseHandler
                    .responseBuilder("Requested Customer by Id", HttpStatus.OK,data);
        }
        return ResponseHandler
                .responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
    }

    // Değerlendirme formu 17
    @GetMapping("/search")
    public ResponseEntity<Object> findByNameLike(@RequestParam("name") String name){
        return ResponseHandler
                .responseBuilder("Request by Name", HttpStatus.OK,customerService.findByNameLike(name));
    }

    // Değerlendirme formu 10
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody AddCustomerRequest request){
        AddCustomerRequest data = customerService.add(request);
        if(data!=null){
            return ResponseHandler.responseBuilder(
                    "Create a Customer request",
                    HttpStatus.CREATED,
                    data
            );
        }
        return ResponseHandler.responseBuilder(
                "ERROR: This mail is used",
                HttpStatus.BAD_REQUEST
        );
    }
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody UpdateCustomerRequest request){
        UpdateCustomerRequest update = customerService.update(request);
        if(update==null){
            return ResponseHandler.responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.responseBuilder(
                "Update Customer request",
                HttpStatus.OK,
                customerService.update(request)
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        if(customerService.delete(id)){
            return ResponseHandler.responseBuilder("Delete request succeed", HttpStatus.OK);
        }
        return ResponseHandler.responseBuilder("ERROR: No such Element", HttpStatus.BAD_REQUEST);
    }
}
