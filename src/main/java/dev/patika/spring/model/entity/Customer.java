package dev.patika.spring.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tbl_customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "customer_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "customer_gen",sequenceName = "customer_seq",allocationSize = 1)
    @Column(name = "customer_id",columnDefinition = "serial")
    private Long id;

    @Column(name = "customer_name",length = 100,nullable = false)
    private String name;

    @Column(name = "customer_phone",length = 100,nullable = false)
    private String phone;

    @Column(name = "customer_mail",length = 100,nullable = false)
    private String mail;

    @Column(name = "customer_address",length = 100,nullable = false)
    private String address;

    @Column(name = "customer_city",length = 100,nullable = false)
    private String city;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer",cascade = CascadeType.REMOVE)
    private List<Animal> animals;


}
