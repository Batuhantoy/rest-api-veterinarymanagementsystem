package dev.patika.spring.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_vaccine")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {
    @Id
    @GeneratedValue(generator = "vaccine_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "vaccine_gen",sequenceName = "vaccine_seq",allocationSize = 1,initialValue = 4)
    @Column(name = "vaccine_id",columnDefinition = "serial")
    private Long id;

    @Column(name = "vaccine_name",length = 100,nullable = false)
    private String name;

    @Column(name = "vaccine_code",length = 100,nullable = false)
    private String code;

    @Temporal(TemporalType.DATE)
    @Column(name = "vaccine_protection_start",nullable = false)
    private LocalDate protectionStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "vaccine_protection_end",nullable = false)
    private LocalDate protectionEndDate;

    //CASCADE OALYINA BURADA ANİMALDA DİKKAT
    //GetVaccineResponseda Animal var ama burada FetchType.LAZY ise serializetion hatası verir
    // buradan animal gelmedigi için reserializetion yapamaz!!
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id",referencedColumnName = "animal_id")
    private Animal animal;
}
