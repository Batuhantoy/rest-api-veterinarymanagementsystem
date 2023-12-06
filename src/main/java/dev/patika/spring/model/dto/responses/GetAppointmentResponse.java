package dev.patika.spring.model.dto.responses;

import dev.patika.spring.model.entity.Animal;
import dev.patika.spring.model.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAppointmentResponse {
    private LocalDateTime appointmentDate;
    private Animal animal;
    private Doctor doctor;
}
