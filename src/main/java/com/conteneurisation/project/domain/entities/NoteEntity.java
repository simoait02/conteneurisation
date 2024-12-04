package com.conteneurisation.project.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Note")
@Data
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_id_seq")
    @SequenceGenerator(name = "note_id_seq", sequenceName = "Note_id_seq", allocationSize = 1)
    private Long idNote;

    @ManyToOne
    @JoinColumn(name = "idEtudiant", referencedColumnName = "idEtudiant", nullable = false)
    private EtudiantEntity etudiant;
    private String name;
    private Double value;
}