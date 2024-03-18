package dev.patika.spring.model.dto.responses;

import dev.patika.spring.model.entity.Appointment;
import dev.patika.spring.model.entity.Vaccine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportResponse {

    private Long id;
    private String title;
    private String diagnosis;
    private double price;
    private String animalName;
    private String customerName;
    private String doctorName;
    private List<Vaccine> vaccineList;
    private Appointment appointment;

}
