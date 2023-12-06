package dev.patika.spring.core.mapper;

import dev.patika.spring.model.dto.requests.AddAvailableDateRequest;
import dev.patika.spring.model.dto.requests.AddCustomerRequest;
import dev.patika.spring.model.dto.requests.UpdateAvailableDateRequest;
import dev.patika.spring.model.dto.requests.UpdateCustomerRequest;
import dev.patika.spring.model.dto.responses.GetAvailableDateResponse;
import dev.patika.spring.model.dto.responses.GetCustomerResponse;
import dev.patika.spring.model.entity.AvailableDate;
import dev.patika.spring.model.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IAvailableDateMapper {
    AvailableDate toEntity(AddAvailableDateRequest request);
    GetAvailableDateResponse toResponse(AvailableDate availableDate);
    List<GetAvailableDateResponse> toResponse(List<AvailableDate> availableDate);
    //@Mapping(target = "id",ignore = true)
    AvailableDate update(UpdateAvailableDateRequest request);
}
