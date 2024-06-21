package com.note.NoteHub.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "review", schema = "public", catalog = "NoteHub")
public class Review {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long reviewId;
    @Column(name = "shortDescription")
    private String shortDescription;
    @Column(name = "dateTime")
    @CreationTimestamp
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    private Student student;

}
