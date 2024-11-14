package com.queryconnect.queryconnect.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id", nullable = false)
    private Long id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "phone", length = 100)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "local_address")
    private Address localAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "permanent_Address")
    private Address permanentAddress;

    @OneToMany(mappedBy = "contact")
    private List<Enquiry> enquiries = new ArrayList<>();

    @OneToMany(mappedBy = "contact")
    private List<Institute> institutes = new ArrayList<>();

}