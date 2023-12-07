package dev.patika.spring.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(generator = "appointment_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "appointment_gen",sequenceName = "appointment_seq",allocationSize = 1)
    @Column(name = "appointment_id",columnDefinition = "serial")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "appointment_date",nullable = false)
    private LocalDateTime appointmentDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id",referencedColumnName = "animal_id")
    private Animal animal;

    //APPOİNTMENT SİLİNİNCE ANİMAL VE DOCTOR BİLGİLERİ DE DİĞER TABLOLARDAN SİLİNECEK Mİ????
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id",referencedColumnName = "doctor_id")
    private Doctor doctor;


}
