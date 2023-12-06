package dev.patika.spring.business.abstracts;


import dev.patika.spring.model.dto.requests.AddAnimalRequest;
import dev.patika.spring.model.dto.requests.UpdateAnimalRequest;
import dev.patika.spring.model.dto.responses.GetAnimalResponse;
import dev.patika.spring.model.dto.responses.GetCustomerResponse;
import dev.patika.spring.model.entity.Animal;

import java.util.List;

public interface IAnimalService {
    AddAnimalRequest add(AddAnimalRequest request);
    UpdateAnimalRequest update(UpdateAnimalRequest request);
    boolean delete(Long id);
    List<GetAnimalResponse> findAll();
    GetAnimalResponse findById(Long id);
    List<GetAnimalResponse> findByNameLike(String name);
    List<GetAnimalResponse> findByCustomer(Long id);
}
