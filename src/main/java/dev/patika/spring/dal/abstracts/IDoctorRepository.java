package dev.patika.spring.dal.abstracts;

import dev.patika.spring.model.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDoctorRepository extends JpaRepository<Doctor,Long> {
}
