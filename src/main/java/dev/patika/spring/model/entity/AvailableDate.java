package dev.patika.spring.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_available_date")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDate {

    @Id
    @GeneratedValue(generator = "available_date_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "appointment_gen",sequenceName = "available_date_seq",initialValue = 50,allocationSize = 1)
    @Column(name = "available_date_id",columnDefinition = "serial")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "available_date",nullable = false)
    private LocalDate availableDate;


    //cascade olayı dikkat
    //@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id",referencedColumnName = "doctor_id")
    private Doctor doctor;

}
