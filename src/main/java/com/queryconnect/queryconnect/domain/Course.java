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
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private Long courseId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "fees")
    private Double fees;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "institute_id")
    private Institute institute;

    @OneToMany(mappedBy = "course")
    private List<Enquirycourse> enquirycourses = new ArrayList<>();

}