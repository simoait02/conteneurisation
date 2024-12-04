package com.conteneurisation.project.services;

import com.conteneurisation.project.domain.entities.EtudiantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EtudiantService {
    EtudiantEntity save(EtudiantEntity etudiantEntity);

    List<EtudiantEntity> findAll();

    Page<EtudiantEntity> findAll(Pageable pageable);

    Optional<EtudiantEntity> findEtudiantById(Long idEtudiant);

    boolean isexists(Long idEtudiant);

    EtudiantEntity partialUpdate(Long idEtudiant, EtudiantEntity etudiantEntity);

    void deleteEtudiant(Long idEtudiant);
}
