package dev.patika.spring.core.mapper;

import dev.patika.spring.model.dto.requests.AddAnimalRequest;
import dev.patika.spring.model.dto.requests.AddCustomerRequest;
import dev.patika.spring.model.dto.requests.UpdateAnimalRequest;
import dev.patika.spring.model.dto.requests.UpdateCustomerRequest;
import dev.patika.spring.model.dto.responses.GetAnimalResponse;
import dev.patika.spring.model.dto.responses.GetCustomerResponse;
import dev.patika.spring.model.entity.Animal;
import dev.patika.spring.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper
public interface IAnimalMapper {
    //@Mapping(source = "request.customerId",target = "customer.id")
    Animal toEntity(AddAnimalRequest request);
    GetAnimalResponse toResponse(Animal animal);
    List<GetAnimalResponse> toResponse(List<Animal> animal);
    //@Mapping(target = "id",ignore = true)

    @Mapping(source = "request.customer.id",target = "customer.id")
    Animal update(UpdateAnimalRequest request);
}
