package com.note.NoteHub.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "review", schema = "public", catalog = "NoteHub")
public class Review {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long reviewId;
    @Column(name = "shortdescription")
    private String shortDescription;
    @Column(name = "estimation")
    private int estimation;
    @Column(name = "datetime")
    private LocalDateTime dateTime;
    @OneToOne
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "teacherId", referencedColumnName = "teacherId")
    private Teacher teacher;
}
