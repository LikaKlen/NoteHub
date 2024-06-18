package com.note.NoteHub.models;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Table(name = "student", schema = "public", catalog = "NoteHub")
@NoArgsConstructor
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long studentId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
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
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "groupId", referencedColumnName = "groupId")
    private Group group;
    @ManyToOne
    @JoinColumn(name = "specializationId", referencedColumnName = "specializationId")
    private Specialization specialization;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private Set<Parent> parent;
}
