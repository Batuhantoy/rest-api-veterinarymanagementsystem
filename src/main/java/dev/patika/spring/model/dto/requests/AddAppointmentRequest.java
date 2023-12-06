package dev.patika.spring.model.dto.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.patika.spring.model.entity.Animal;
import dev.patika.spring.model.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAppointmentRequest {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentDate;
    private Animal animal;
    private Doctor doctor;
}
