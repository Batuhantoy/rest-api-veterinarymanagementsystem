package dev.patika.spring.dal.abstracts;

import dev.patika.spring.model.entity.Animal;
import dev.patika.spring.model.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVaccineRepository extends JpaRepository<Vaccine,Long> {

    //SELECT vaccine_protection_end<'2023-08-10' FROM tbl_vaccine WHERE vaccine_name='Başka Aşı' AND vaccine_code='D2' AND animal_id=5
    @Query("SELECT v.protectionEndDate<:protectionStartDate FROM Vaccine v WHERE v.name=:name AND v.code=:code AND v.animal=:animal")
    boolean isReadyForVaccine(String name, String code, Animal animal,LocalDate protectionStartDate);

    @Query("SELECT v.protectionEndDate<:protectionStartDate FROM Vaccine v WHERE v.id=:id AND v.name=:name AND v.code=:code AND v.animal=:animal")
    boolean isReadyForVaccine(Long id,String name, String code, Animal animal,LocalDate protectionStartDate);

    List<Vaccine> findByAnimalId(Long animalId);

    //SELECT * FROM tbl_vaccine WHERE (vaccine_protection_end-'2023-10-01')>0 AND (vaccine_protection_end-'2023-10-01')<10
    @Query("SELECT v FROM Vaccine v WHERE v.protectionStartDate<=:startDate AND v.protectionEndDate>=:endDate")
    List<Vaccine> findByDates(LocalDate startDate,LocalDate endDate);



}
