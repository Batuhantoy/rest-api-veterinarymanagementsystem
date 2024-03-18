package dev.patika.spring.dal.abstracts;

import dev.patika.spring.model.entity.Report;
import dev.patika.spring.model.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IReportRepository extends JpaRepository<Report,Long> {
    Optional<Report> findByAppointmentId(Long appointmentId);

}
