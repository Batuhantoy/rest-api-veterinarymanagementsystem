package dev.patika.spring.core.mapper;

import dev.patika.spring.model.dto.requests.AddAnimalRequest;
import dev.patika.spring.model.dto.requests.AddDoctorRequest;
import dev.patika.spring.model.dto.requests.UpdateAnimalRequest;
import dev.patika.spring.model.dto.requests.UpdateDoctorRequest;
import dev.patika.spring.model.dto.responses.GetAnimalResponse;
import dev.patika.spring.model.dto.responses.GetDoctorResponse;
import dev.patika.spring.model.entity.Animal;
import dev.patika.spring.model.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.print.Doc;
import java.util.List;

@Mapper
public interface IDoctorMapper {
    Doctor toEntity(AddDoctorRequest request);
    GetDoctorResponse toResponse(Doctor doctor);
    List<GetDoctorResponse> toResponse(List<Doctor> doctor);

    Doctor update(UpdateDoctorRequest request);
}
