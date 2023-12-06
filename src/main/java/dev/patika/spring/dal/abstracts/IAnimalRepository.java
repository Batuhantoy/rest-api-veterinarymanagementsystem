package dev.patika.spring.dal.abstracts;

import dev.patika.spring.model.entity.Animal;
import dev.patika.spring.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAnimalRepository extends JpaRepository<Animal,Long> {
    List<Animal> findByNameStartingWith(String name);
    List<Animal> findByCustomerId(Long customerId);
}
