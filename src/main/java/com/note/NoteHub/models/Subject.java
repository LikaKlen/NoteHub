package com.note.NoteHub.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "subject", schema = "public", catalog = "NoteHub")
public class Subject {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long subjectId;
    @Column(name = "subjectname")
    private String subjectName;
}
