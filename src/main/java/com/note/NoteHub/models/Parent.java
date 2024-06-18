package com.note.NoteHub.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "parent", schema = "public", catalog = "NoteHub")
public class Parent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long parentId;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "patronymic")//отчество
    private String patronymic;
    @Column(name = "age")
    private String age;
//    @Column(name = "login")
//    private String login;
//    @Column(name = "password")
//    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @ManyToMany
    @JoinTable(name = "Has",
            joinColumns = @JoinColumn(name = "parentId", referencedColumnName = "parentId"),
            inverseJoinColumns = @JoinColumn(name = "studentId", referencedColumnName = "studentId"))
    private Set<Student> student;
}
