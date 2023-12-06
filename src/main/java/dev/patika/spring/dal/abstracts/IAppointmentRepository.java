package dev.patika.spring.dal.abstracts;

import dev.patika.spring.model.entity.Appointment;
import dev.patika.spring.model.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment,Long> {
    boolean existsByAppointmentDateAndDoctor(LocalDateTime appointmentDate, Doctor doctor);

    //@Query("SELECT a FROM Appointment a WHERE a.doctor.name=:doctorName AND (a.appointmentDat BETWEEN :startDate AND :endDate)")
    //List<Appointment> findByAppointmentDateBetweenAndDoctorName(LocalDate startDate,LocalDate endDate,String doctorName);

    //SELECT a.appointment_id,a.appointment_date,a.animal_id,a.doctor_id,d.doctor_name FROM tbl_appointment a INNER JOIN tbl_doctor d ON a.doctor_id = d.doctor_id
    //WHERE a.appointment_date BETWEEN '2023-12-05' AND '2024-01-05'
    @Query(value = "SELECT a.appointment_id,a.appointment_date,a.animal_id,a.doctor_id,d.doctor_name FROM tbl_appointment a\n"
            +"INNER JOIN tbl_doctor d ON a.doctor_id = d.doctor_id WHERE d.doctor_name=:doctorName AND (a.appointment_date BETWEEN :startDate AND :endDate)",nativeQuery = true)
    List<Appointment> findByAppointmentDateBetweenAndDoctorName(LocalDate startDate,LocalDate endDate,String doctorName);

    @Query(value = "SELECT a.appointment_id,a.appointment_date,a.animal_id,a.doctor_id,d.animal_name FROM tbl_appointment a\n"
            +"INNER JOIN tbl_animal d ON a.animal_id = d.animal_id WHERE d.animal_name=:animalName AND (a.appointment_date BETWEEN :startDate AND :endDate)",nativeQuery = true)
    List<Appointment> findByAppointmentDateBetweenAndAnimalName(LocalDate startDate,LocalDate endDate,String animalName);
}
