package dev.patika.spring.business.concretes;

import dev.patika.spring.business.abstracts.IAnimalService;
import dev.patika.spring.core.mapper.IAnimalMapper;
import dev.patika.spring.dal.abstracts.IAnimalRepository;
import dev.patika.spring.model.dto.requests.AddAnimalRequest;
import dev.patika.spring.model.dto.requests.UpdateAnimalRequest;
import dev.patika.spring.model.dto.responses.GetAnimalResponse;
import dev.patika.spring.model.entity.Animal;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AnimalManager implements IAnimalService {

    private final IAnimalRepository animalRepository;
    private IAnimalMapper animalMapper;

    @Override
    public AddAnimalRequest add(AddAnimalRequest request) {
        animalRepository.save(animalMapper.toEntity(request));
        return request;
    }

    @Override
    public UpdateAnimalRequest update(UpdateAnimalRequest request) {
        if(!animalRepository.existsById(request.getId())){
            return null;
        }
        animalRepository.save(animalMapper.update(request));
        return request;
    }

    @Override
    public boolean delete(Long id) {
        if(animalRepository.existsById(id)){
            animalRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    @Override
    public Animal findById(Long id) {
        Optional<Animal> animal = animalRepository.findById(id);
        // Değerlendirme formu 25
        if(animal.isEmpty()){
            throw new RuntimeException(id + " id’li kayıt sistemde bulunamadı.");
        }
        return animal.get();

        /*if(animalRepository.existsById(id)){
            return animalMapper.toResponse(animalRepository.findById(id).get());
        }
        return null;*/
    }

    @Override
    public List<Animal> findByNameLike(String name) {
        return animalRepository.findByNameStartingWith(name);
    }

    @Override
    public List<Animal> findByCustomer(Long id) {
        return animalRepository.findByCustomerId(id);
    }
}
