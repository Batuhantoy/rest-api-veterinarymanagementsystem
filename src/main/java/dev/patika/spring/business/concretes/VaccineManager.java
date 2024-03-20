package dev.patika.spring.business.concretes;

import dev.patika.spring.business.abstracts.IVaccineService;
import dev.patika.spring.core.mapper.IVaccineMapper;
import dev.patika.spring.dal.abstracts.IVaccineRepository;
import dev.patika.spring.model.dto.requests.AddVaccineRequest;
import dev.patika.spring.model.dto.requests.UpdateVaccineRequest;
import dev.patika.spring.model.dto.responses.GetVaccineResponse;
import dev.patika.spring.model.entity.Vaccine;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class VaccineManager implements IVaccineService {

    private final IVaccineRepository vaccineRepository;
    private IVaccineMapper vaccineMapper;

    @Override
    public AddVaccineRequest add(AddVaccineRequest request) {
        // Değerlendirme formu 19
        if(vaccineRepository.isReadyForVaccine(request.getName(), request.getCode(),request.getAnimal(),request.getProtectionStartDate())){
            vaccineRepository.save(vaccineMapper.toEntity(request));
            return request;
        }
        return null;
    }

    @Override
    public UpdateVaccineRequest update(UpdateVaccineRequest request) {
        if(vaccineRepository.existsById(request.getId())
                && vaccineRepository.isReadyForVaccine(request.getId(),request.getName(), request.getCode(), request.getAnimal(),request.getProtectionStartDate())){
            vaccineRepository.save(vaccineMapper.update(request));
            return request;
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if(vaccineRepository.existsById(id)){
            vaccineRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Vaccine> findAll() {
        return vaccineRepository.findAll();
    }

    @Override
    public List<Vaccine> findByAnimalId(Long animalId) {
        return vaccineRepository.findByAnimalId(animalId);
    }

    @Override
    public Vaccine findById(Long id) {
        return vaccineRepository.findById(id).orElse(null);
        /*if(vaccineRepository.existsById(id)){
            return vaccineMapper.toResponse(vaccineRepository.findById(id).get());
        }
        return null;*/
    }
    @Override
    public List<Vaccine> findByName(String name) {
        return vaccineRepository.findByName(name);
    }

    @Override
    public List<Vaccine> findByDates(LocalDate startDate, LocalDate endDate) {
        return vaccineRepository.findByDates(startDate, endDate);
    }
}
