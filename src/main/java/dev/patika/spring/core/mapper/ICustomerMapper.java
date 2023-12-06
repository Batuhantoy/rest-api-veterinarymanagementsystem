package dev.patika.spring.core.mapper;

import dev.patika.spring.model.dto.requests.AddCustomerRequest;
import dev.patika.spring.model.dto.requests.UpdateCustomerRequest;
import dev.patika.spring.model.dto.responses.GetCustomerResponse;
import dev.patika.spring.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface ICustomerMapper {
    //@Mapping(target = "id",ignore = true)
    Customer toEntity(AddCustomerRequest request);
    GetCustomerResponse toResponse(Customer customer);
    List<GetCustomerResponse> toResponse(List<Customer> customer);

    //@Mapping(target = "id",ignore = true)
    Customer update(UpdateCustomerRequest request);
}
