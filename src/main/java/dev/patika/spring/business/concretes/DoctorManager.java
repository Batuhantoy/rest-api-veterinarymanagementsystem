package dev.patika.spring.business.concretes;

import dev.patika.spring.business.abstracts.IDoctorService;
import dev.patika.spring.core.mapper.IDoctorMapper;
import dev.patika.spring.dal.abstracts.IDoctorRepository;
import dev.patika.spring.model.dto.requests.AddDoctorRequest;
import dev.patika.spring.model.dto.requests.UpdateDoctorRequest;
import dev.patika.spring.model.dto.responses.GetDoctorResponse;
import dev.patika.spring.model.entity.Doctor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class DoctorManager implements IDoctorService {

    private final IDoctorRepository doctorRepository;
    private IDoctorMapper doctorMapper;


    @Override
    public AddDoctorRequest add(AddDoctorRequest request) {
        doctorRepository.save(doctorMapper.toEntity(request));
        return request;
    }

    @Override
    public UpdateDoctorRequest update(UpdateDoctorRequest request) {
        if(!doctorRepository.existsById(request.getId())){
            return null;
        }
        doctorRepository.save(doctorMapper.update(request));
        return request;
    }

    @Override
    public boolean delete(Long id) {
        if(doctorRepository.existsById(id)){
            doctorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<GetDoctorResponse> findAll() {
        return doctorMapper.toResponse(doctorRepository.findAll());
    }

    @Override
    public GetDoctorResponse findById(Long id) {
        if(doctorRepository.existsById(id)){
            return doctorMapper.toResponse(doctorRepository.findById(id).get());
        }
        return null;
    }
}
