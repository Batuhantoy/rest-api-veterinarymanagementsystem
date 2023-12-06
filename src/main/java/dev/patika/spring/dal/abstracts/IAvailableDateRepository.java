package dev.patika.spring.dal.abstracts;

import dev.patika.spring.model.entity.AvailableDate;
import dev.patika.spring.model.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAvailableDateRepository extends JpaRepository<AvailableDate,Long> {
    boolean existsByAvailableDateAndDoctor(LocalDate availableDate, Doctor doctor);
}
