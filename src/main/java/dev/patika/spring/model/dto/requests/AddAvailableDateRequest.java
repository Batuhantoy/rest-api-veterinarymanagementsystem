package dev.patika.spring.model.dto.requests;

import dev.patika.spring.model.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAvailableDateRequest {
    private LocalDate availableDate;
    private Doctor doctor;
}
