package dev.patika.spring.business.abstracts;

import dev.patika.spring.model.dto.requests.AddVaccineRequest;
import dev.patika.spring.model.dto.requests.UpdateVaccineRequest;
import dev.patika.spring.model.dto.responses.GetVaccineResponse;
import dev.patika.spring.model.entity.Vaccine;

import java.time.LocalDate;
import java.util.List;

public interface IVaccineService {
    AddVaccineRequest add(AddVaccineRequest request);
    UpdateVaccineRequest update(UpdateVaccineRequest request);
    boolean delete(Long id);
    List<Vaccine> findAll();
    List<Vaccine> findByAnimalId(Long animalId);
    Vaccine findById(Long id);
    List<Vaccine> findByDates(LocalDate startDate, LocalDate endDate);
    public List<Vaccine> findByName(String name);
}
