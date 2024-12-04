package com.conteneurisation.project.services.impl;

import com.conteneurisation.project.domain.entities.NoteEntity;
import com.conteneurisation.project.repositories.NoteRepository;
import com.conteneurisation.project.services.NoteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }
    @Override
    public NoteEntity save(NoteEntity noteEntity) {
        return noteRepository.save(noteEntity);
    }

    @Override
    public List<NoteEntity> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Page<NoteEntity> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Optional<NoteEntity> findNoteById(Long idNote) {
        return noteRepository.findById(idNote);
    }

    @Override
    public boolean isExist(Long idNote) {
        return !noteRepository.existsById(idNote);
    }

    @Override
    public NoteEntity partialUpdate(Long idNote, NoteEntity noteEntity) {
        noteEntity.setIdNote(idNote);
        return noteRepository.findById(idNote).map(
                existingNote->{
                    Optional.ofNullable(existingNote.getName()).ifPresent(existingNote::setName);
                    Optional.ofNullable(existingNote.getValue()).ifPresent(existingNote::setValue);
                    return noteRepository.save(existingNote);
                }
        ).orElseThrow(() -> new RuntimeException("Note not found"));
    }

    @Override
    public void deleteNote(Long idNote) {
        noteRepository.deleteById(idNote);
    }
    @Override
    public List<NoteEntity> findNotesByEtudiantId(Long idEtudiant) {
        return noteRepository.findByEtudiant_IdEtudiant(idEtudiant);
    }
}
