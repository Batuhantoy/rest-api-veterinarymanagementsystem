package dev.patika.spring.core.mapper;

import dev.patika.spring.model.dto.requests.AddDoctorRequest;
import dev.patika.spring.model.dto.requests.AddVaccineRequest;
import dev.patika.spring.model.dto.requests.UpdateDoctorRequest;
import dev.patika.spring.model.dto.requests.UpdateVaccineRequest;
import dev.patika.spring.model.dto.responses.GetDoctorResponse;
import dev.patika.spring.model.dto.responses.GetVaccineResponse;
import dev.patika.spring.model.entity.Doctor;
import dev.patika.spring.model.entity.Vaccine;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IVaccineMapper {

    Vaccine toEntity(AddVaccineRequest request);
    GetVaccineResponse toResponse(Vaccine vaccine);
    List<GetVaccineResponse> toResponse(List<Vaccine> vaccine);
    Vaccine update(UpdateVaccineRequest request);
}
