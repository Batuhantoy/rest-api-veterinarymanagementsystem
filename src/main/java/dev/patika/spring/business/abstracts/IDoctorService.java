package dev.patika.spring.business.abstracts;

import dev.patika.spring.model.dto.requests.AddDoctorRequest;
import dev.patika.spring.model.dto.requests.UpdateDoctorRequest;
import dev.patika.spring.model.dto.responses.GetDoctorResponse;
import dev.patika.spring.model.entity.Doctor;

import java.util.List;

public interface IDoctorService {
    AddDoctorRequest add(AddDoctorRequest request);
    UpdateDoctorRequest update(UpdateDoctorRequest request);
    boolean delete(Long id);
    List<GetDoctorResponse> findAll();
    GetDoctorResponse findById(Long id);
}
