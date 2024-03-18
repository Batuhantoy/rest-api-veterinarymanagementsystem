package dev.patika.spring.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tbl_doctor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(generator = "doctor_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "doctor_gen",sequenceName = "doctor_seq",allocationSize = 1,initialValue = 4)
    @Column(name = "doctor_id",columnDefinition = "serial")
    private Long id;

    @Column(name = "doctor_name",length = 100,nullable = false)
    private String name;

    @Column(name = "doctor_phone",length = 100,nullable = false)
    private String phone;

    @Column(name = "doctor_mail",length = 100,nullable = false)
    private String mail;

    @Column(name = "doctor_address",length = 100,nullable = false)
    private String address;

    @Column(name = "doctor_city",length = 100,nullable = false)
    private String city;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "doctor",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Appointment> appointments;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "doctor",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<AvailableDate> availableDates;
}
