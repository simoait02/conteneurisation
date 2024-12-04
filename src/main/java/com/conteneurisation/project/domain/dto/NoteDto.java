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
}
