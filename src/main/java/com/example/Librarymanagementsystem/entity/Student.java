package com.example.Librarymanagementsystem.entity;

import com.example.Librarymanagementsystem.enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private int mobNo;

    @Enumerated(EnumType.STRING)
    private Department department;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    Card card;
}
