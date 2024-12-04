package com.conteneurisation.project.repositories;

import com.conteneurisation.project.domain.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> , PagingAndSortingRepository<NoteEntity, Long> {
    List<NoteEntity> findByEtudiant_IdEtudiant(Long idEtudiant);

}
