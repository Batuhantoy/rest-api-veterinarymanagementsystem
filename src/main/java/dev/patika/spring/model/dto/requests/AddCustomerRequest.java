package dev.patika.spring.model.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
    private String name;
    private String phone;
    private String mail;
    private String address;
    private String city;
}
