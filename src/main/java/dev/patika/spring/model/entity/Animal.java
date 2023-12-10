package dev.patika.spring.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_animal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(generator = "animal_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "animal_gen",sequenceName = "animal_seq",allocationSize = 1,initialValue = 4)
    @Column(name = "animal_id",columnDefinition = "serial")
    private Long id;

    @Column(name = "animal_name",length = 100,nullable = false)
    private String name;

    @Column(name = "animal_species",length = 100,nullable = false)
    private String species;

    @Column(name = "animal_breed",length = 100,nullable = false)
    private String breed;

    @Column(name = "animal_gender",length = 100,nullable = false)
    private String gender;

    @Column(name = "animal_colour",length = 100,nullable = false)
    private String colour;

    @Temporal(TemporalType.DATE)
    @Column(name = "animal_birth_date",length = 100,nullable = false)
    private LocalDate dateOfBirth;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    private Customer customer;

    // I think this should not be remove cascade
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "animal",cascade = CascadeType.REMOVE)
    private List<Vaccine> vaccines;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "animal",cascade = CascadeType.REMOVE)
    private List<Appointment> appointments;

}
