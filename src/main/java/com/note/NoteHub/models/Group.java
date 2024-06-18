package com.note.NoteHub.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "group", schema = "public", catalog = "NoteHub")
public class Group {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long groupId;
    @Column(name = "groupName")
    private String groupName;
}
