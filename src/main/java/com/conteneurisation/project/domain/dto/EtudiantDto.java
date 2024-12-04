package com.conteneurisation.project.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EtudiantDto {
    private Long idEtudiant;
    private String name;
    private String CreationDate= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
}
