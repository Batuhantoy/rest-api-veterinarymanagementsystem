package dev.patika.spring.core.mapper;

import dev.patika.spring.model.dto.requests.AddAnimalRequest;
import dev.patika.spring.model.dto.requests.AddAppointmentRequest;
import dev.patika.spring.model.dto.requests.UpdateAnimalRequest;
import dev.patika.spring.model.dto.requests.UpdateAppointmentRequest;
import dev.patika.spring.model.dto.responses.GetAnimalResponse;
import dev.patika.spring.model.dto.responses.GetAppointmentResponse;
import dev.patika.spring.model.entity.Animal;
import dev.patika.spring.model.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface IAppointmentMapper {
    Appointment toEntity(AddAppointmentRequest request);
    GetAppointmentResponse toResponse(Appointment appointment);
    List<GetAppointmentResponse> toResponse(List<Appointment> appointment);

    @Mapping(source = "request.animal.id",target = "animal.id")
    @Mapping(source = "request.doctor.id",target = "doctor.id")
    Appointment update(UpdateAppointmentRequest request);
}
