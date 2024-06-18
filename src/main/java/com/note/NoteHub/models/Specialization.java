package com.note.NoteHub.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "specialization", schema = "public", catalog = "NoteHub")
public class Specialization {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long specializationId;
    @Column(name = "specializationName")
    private String specializationName;
}
