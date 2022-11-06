package com.javatechie.spring.batch.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "customer_info")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "contact")
    private String contactNo;

    @Column(name = "country")
    private String country;

    @Column(name = "dob")
    private String dob;
}
