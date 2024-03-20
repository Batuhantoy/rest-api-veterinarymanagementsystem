package dev.patika.spring.business.concretes;

import dev.patika.spring.business.abstracts.IAppointmentService;
import dev.patika.spring.business.abstracts.IAvailableDateService;
import dev.patika.spring.business.abstracts.IDoctorService;
import dev.patika.spring.core.mapper.IAppointmentMapper;
import dev.patika.spring.dal.abstracts.IAppointmentRepository;
import dev.patika.spring.model.dto.requests.AddAppointmentRequest;
import dev.patika.spring.model.dto.requests.UpdateAppointmentRequest;
import dev.patika.spring.model.dto.responses.GetAppointmentResponse;
import dev.patika.spring.model.entity.Appointment;
import dev.patika.spring.model.entity.Doctor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppointmentManager implements IAppointmentService {

    private final IAppointmentRepository appointmentRepository;
    private IAppointmentMapper appointmentMapper;
    private IAvailableDateService availableService;


    @Override
    public AddAppointmentRequest add(AddAppointmentRequest request) {
        // Değerlendirme formu 22
        if(availableService.existsByAvailableDateAndDoctor(request.getAppointmentDate().toLocalDate(),request.getDoctor())
        && !appointmentRepository.existsByAppointmentDateAndDoctor(request.getAppointmentDate(),request.getDoctor())){
            appointmentRepository.save(appointmentMapper.toEntity(request));
            return request;
        }
        return null;
    }

    @Override
    public UpdateAppointmentRequest update(UpdateAppointmentRequest request) {
        if(!appointmentRepository.existsById(request.getId())){
            return null;
        }
        appointmentRepository.save(appointmentMapper.update(request));
        return request;
    }

    @Override
    public boolean delete(Long id) {

        if(appointmentRepository.existsById(id)){
            appointmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment findById(Long id) {

        return appointmentRepository.findById(id).orElse(null);
        /*if(appointmentRepository.existsById(id)){
            return appointmentMapper.toResponse(appointmentRepository.findById(id).get());
        }
        return null;*/
    }


    @Override
    public List<Appointment> findByBetweenDateAndDoctor(LocalDate startDate, LocalDate endDate, String doctorName) {
        if(startDate!=null || endDate!=null){
            return appointmentRepository.findByAppointmentDateBetweenAndDoctorName(startDate, endDate, doctorName);
        }
        return null;
    }


    @Override
    public List<Appointment> findByBetweenDateAndAnimal(LocalDate startDate, LocalDate endDate, String animalName) {
        if(startDate!=null || endDate!=null){
            return appointmentRepository.findByAppointmentDateBetweenAndAnimalName(startDate, endDate, animalName);
        }
        return null;
    }
}
