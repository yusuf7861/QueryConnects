package com.queryconnect.queryconnect.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId", nullable = false)
    private Long id;

    @Column(name = "detail", length = 200)
    private String detail;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "zip")
    private Integer zip;

    @OneToMany(mappedBy = "localAddress")
    private List<Contact> contacts = new ArrayList<>();

    @OneToMany(mappedBy = "permanentAddress")
    private List<Contact> contacts_per = new ArrayList<>();

}