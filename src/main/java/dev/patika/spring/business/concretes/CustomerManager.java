package dev.patika.spring.business.concretes;

import dev.patika.spring.business.abstracts.ICustomerService;
import dev.patika.spring.core.mapper.IAnimalMapper;
import dev.patika.spring.core.mapper.ICustomerMapper;
import dev.patika.spring.dal.abstracts.ICustomerRepository;
import dev.patika.spring.model.dto.requests.AddCustomerRequest;
import dev.patika.spring.model.dto.requests.UpdateCustomerRequest;
import dev.patika.spring.model.dto.responses.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CustomerManager implements ICustomerService {

    private final ICustomerRepository customerRepository;
    private ICustomerMapper customerMapper;
    private IAnimalMapper animalMapper;


    @Override
    public AddCustomerRequest add(AddCustomerRequest request) {
        customerRepository.save(customerMapper.toEntity(request));
        return request;
    }

    @Override
    public UpdateCustomerRequest update(UpdateCustomerRequest request) {
        if(!customerRepository.existsById(request.getId())){
            return null;
        }
        customerRepository.save(customerMapper.update(request));
        return request;
    }

    @Override
    public boolean delete(Long id) {
        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<GetCustomerResponse> findAll() {
        return customerMapper.toResponse(customerRepository.findAll());
    }

    @Override
    public GetCustomerResponse findById(Long id) {
        return customerMapper.toResponse(customerRepository.findById(id).orElse(null));
        /*if(customerRepository.existsById(id)){
            return customerMapper.toResponse(customerRepository.findById(id).get());
        }
        return null;*/
    }

    // Değerlendirme formu 17
    @Override
    public List<GetCustomerResponse> findByNameLike(String name) {
        return customerMapper.toResponse(customerRepository.findByNameStartingWith(name));
    }

}
