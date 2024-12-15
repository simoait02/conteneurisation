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

    public Long getIdNote() {
        return idNote;
    }

    public void setIdNote(Long idNote) {
        this.idNote = idNote;
    }

    public EtudiantEntity getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(EtudiantEntity etudiant) {
        this.etudiant = etudiant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}