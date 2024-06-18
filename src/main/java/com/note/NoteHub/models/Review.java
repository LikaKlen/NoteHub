package com.note.NoteHub.models;

import jakarta.persistence.*;
import lombok.Data;

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
    //studentId
    //teacherId
    //date
}
