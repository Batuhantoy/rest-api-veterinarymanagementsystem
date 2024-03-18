package dev.patika.spring.business.abstracts;

import dev.patika.spring.model.dto.requests.AddCustomerRequest;
import dev.patika.spring.model.dto.requests.UpdateCustomerRequest;
import dev.patika.spring.model.dto.responses.GetAnimalResponse;
import dev.patika.spring.model.dto.responses.GetCustomerResponse;
import dev.patika.spring.model.entity.Customer;

import java.util.List;

public interface ICustomerService {
    AddCustomerRequest add(AddCustomerRequest request);
    UpdateCustomerRequest update(UpdateCustomerRequest request);
    boolean delete(Long id);
    List<Customer> findAll();
    GetCustomerResponse findById(Long id);
    List<GetCustomerResponse> findByNameLike(String name);
}
