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

    //ERROR: Null Exception -> @Query("SELECT v.protectionEndDate<:protectionStartDate FROM Vaccine v WHERE v.name=:name AND v.code=:code AND v.animal=:animal")
    @Query("SELECT Count(*)=0 FROM Vaccine v WHERE v.protectionEndDate>:protectionStartDate AND v.name=:name AND v.code=:code AND v.animal=:animal")
    boolean isReadyForVaccine(String name, String code, Animal animal,LocalDate protectionStartDate);


    //@Query("SELECT Count(*)=0 FROM Vaccine v WHERE v.id=:id AND v.protectionEndDate>:protectionStartDate AND v.name=:name AND v.code=:code AND v.animal=:animal")
    @Query("SELECT v.protectionEndDate<:protectionStartDate FROM Vaccine v WHERE v.id=:id AND v.name=:name AND v.code=:code AND v.animal=:animal")
    boolean isReadyForVaccine(Long id,String name, String code, Animal animal,LocalDate protectionStartDate);

    List<Vaccine> findByAnimalId(Long animalId);

    //SELECT * FROM tbl_vaccine WHERE (vaccine_protection_end-'2023-10-01')>0 AND (vaccine_protection_end-'2023-10-01')<10
    @Query(value = "SELECT * FROM tbl_vaccine WHERE vaccine_protection_end>=:startDate AND vaccine_protection_end<=:endDate",nativeQuery = true)
    List<Vaccine> findByDates(LocalDate startDate,LocalDate endDate);

    List<Vaccine> findByName(String name);

}
