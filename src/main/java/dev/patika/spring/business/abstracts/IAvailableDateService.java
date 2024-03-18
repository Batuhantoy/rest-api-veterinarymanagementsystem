package dev.patika.spring.business.abstracts;

import dev.patika.spring.model.dto.requests.AddAnimalRequest;
import dev.patika.spring.model.dto.requests.AddAvailableDateRequest;
import dev.patika.spring.model.dto.requests.UpdateAnimalRequest;
import dev.patika.spring.model.dto.requests.UpdateAvailableDateRequest;
import dev.patika.spring.model.dto.responses.GetAnimalResponse;
import dev.patika.spring.model.dto.responses.GetAvailableDateResponse;
import dev.patika.spring.model.entity.AvailableDate;
import dev.patika.spring.model.entity.Doctor;

import java.time.LocalDate;
import java.util.List;

public interface IAvailableDateService {
    AddAvailableDateRequest add(AddAvailableDateRequest request);
    UpdateAvailableDateRequest update(UpdateAvailableDateRequest request);
    boolean delete(Long id);
    List<AvailableDate> findAll();
    AvailableDate findById(Long id);
    boolean existsByAvailableDateAndDoctor(LocalDate availableDate, Doctor doctor);
}
