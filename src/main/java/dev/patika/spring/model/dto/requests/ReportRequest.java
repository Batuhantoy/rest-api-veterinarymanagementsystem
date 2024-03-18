package dev.patika.spring.model.dto.requests;

import dev.patika.spring.model.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportRequest {
    private String title;
    private String diagnosis;
    private double price;
    private Appointment appointment;
}
