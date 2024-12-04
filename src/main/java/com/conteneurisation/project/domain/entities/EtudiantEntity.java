package com.conteneurisation.project.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Etudiant")
@Data
public class EtudiantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etudiant_seq")
    @SequenceGenerator(name = "etudiant_seq", sequenceName = "Etudiant_id_seq", allocationSize = 1)
    private Long idEtudiant;
    private String name;
    @Column(name = "creation_date")
    private String creationDate;
    @PrePersist
    public void prePersist() {
        this.creationDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    }
}
