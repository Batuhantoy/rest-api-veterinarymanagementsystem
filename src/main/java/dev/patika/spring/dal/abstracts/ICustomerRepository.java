package dev.patika.spring.dal.abstracts;

import dev.patika.spring.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByNameStartingWith(String name);
    boolean existsByMail(String mail);
}