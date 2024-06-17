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
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "patronymic")//отчество
    private String patronymic;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;


}
