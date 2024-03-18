package dev.patika.spring.business.concretes;

import dev.patika.spring.business.abstracts.IAvailableDateService;
import dev.patika.spring.core.mapper.IAvailableDateMapper;
import dev.patika.spring.dal.abstracts.IAvailableDateRepository;
import dev.patika.spring.model.dto.requests.AddAvailableDateRequest;
import dev.patika.spring.model.dto.requests.UpdateAvailableDateRequest;
import dev.patika.spring.model.dto.responses.GetAvailableDateResponse;
import dev.patika.spring.model.entity.AvailableDate;
import dev.patika.spring.model.entity.Doctor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class AvailableDateManager implements IAvailableDateService {

    private final IAvailableDateRepository repository;
    private IAvailableDateMapper mapper;



    @Override
    public AddAvailableDateRequest add(AddAvailableDateRequest request) {
        repository.save(mapper.toEntity(request));
        return request;
    }

    @Override
    public UpdateAvailableDateRequest update(UpdateAvailableDateRequest request) {
        if(!repository.existsById(request.getId())){
            return null;
        }
        repository.save(mapper.update(request));
        return request;
    }

    @Override
    public boolean delete(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<AvailableDate> findAll() {
        return repository.findAll();
    }

    @Override
    public AvailableDate findById(Long id) {
        return repository.findById(id).orElse(null);
        /*if(repository.existsById(id)){
            return mapper.toResponse(repository.findById(id).get());
        }
        return null;*/
    }

    @Override
    public boolean existsByAvailableDateAndDoctor(LocalDate availableDate, Doctor doctor) {

        return repository.existsByAvailableDateAndDoctor(availableDate, doctor);
    }
}
