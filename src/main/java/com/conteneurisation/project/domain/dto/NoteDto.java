package com.conteneurisation.project.domain.dto;

import com.conteneurisation.project.domain.entities.EtudiantEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteDto {
    private Long idNote;
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
