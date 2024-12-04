package com.conteneurisation.project.services;


import com.conteneurisation.project.domain.entities.NoteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface NoteService {
    NoteEntity save(NoteEntity noteEntity);

    List<NoteEntity> findAll();

    Page<NoteEntity> findAll(Pageable pageable);

    Optional<NoteEntity> findNoteById(Long idNote);

    boolean isExist(Long idNote);

    NoteEntity partialUpdate(Long idNote, NoteEntity NoteEntity);

    void deleteNote(Long idNote);

    List<NoteEntity> findNotesByEtudiantId(Long idEtudiant);

}
