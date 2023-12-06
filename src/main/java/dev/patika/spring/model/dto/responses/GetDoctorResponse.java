package dev.patika.spring.model.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDoctorResponse {
    private String name;
    private String phone;
    private String mail;
    private String address;
    private String city;
}
