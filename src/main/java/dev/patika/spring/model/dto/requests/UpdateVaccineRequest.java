package dev.patika.spring.model.dto.requests;

import dev.patika.spring.model.entity.Animal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVaccineRequest {
    private Long id;
    private String name;
    private String code;
    private LocalDate protectionStartDate;
    private LocalDate protectionEndDate;
    private Animal animal;
}
