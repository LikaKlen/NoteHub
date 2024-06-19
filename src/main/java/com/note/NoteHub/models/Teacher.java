package com.note.NoteHub.models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "teacher", schema = "public", catalog = "NoteHub")
@NoArgsConstructor
public class Teacher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long teacherId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "patronymic")//отчество
    private String patronymic;
//    @Column(name = "age")
//    private String age;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private String phoneNumber;



}
