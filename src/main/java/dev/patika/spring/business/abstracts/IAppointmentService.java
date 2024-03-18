package dev.patika.spring.business.abstracts;

import dev.patika.spring.model.dto.requests.AddAppointmentRequest;
import dev.patika.spring.model.dto.requests.UpdateAppointmentRequest;
import dev.patika.spring.model.dto.responses.GetAppointmentResponse;
import dev.patika.spring.model.entity.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface IAppointmentService {
    AddAppointmentRequest add(AddAppointmentRequest request);
    UpdateAppointmentRequest update(UpdateAppointmentRequest request);
    boolean delete(Long id);
    List<Appointment> findAll();
    Appointment findById(Long id);
    List<GetAppointmentResponse> findByBetweenDateAndDoctor(LocalDate startDate, LocalDate endDate, String doctorName);
    List<GetAppointmentResponse> findByBetweenDateAndAnimal(LocalDate startDate, LocalDate endDate, String animalName);
}
