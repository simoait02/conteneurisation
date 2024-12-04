package com.conteneurisation.project.controllers;

import com.conteneurisation.project.domain.dto.NoteDto;
import com.conteneurisation.project.domain.entities.NoteEntity;
import com.conteneurisation.project.mappers.impl.NoteMapperImpl;
import com.conteneurisation.project.services.NoteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    private final NoteService noteService;
    private final NoteMapperImpl noteMapper;

    public NoteController(NoteService noteService,NoteMapperImpl noteMapper) {
        this.noteService = noteService;
        this.noteMapper = noteMapper;
    }

    @PostMapping(path = "/Notes")
    public NoteDto addNote(@RequestBody NoteDto noteDto) {
        NoteEntity noteEntity=noteMapper.mapFrom(noteDto);
        NoteEntity savedNoteEntity=noteService.save(noteEntity);
        return noteMapper.mapTo(savedNoteEntity);
    }
    @GetMapping(path = "/Notes")
    public Page<NoteDto> getAllNotes(Pageable pageable) {
        Page<NoteEntity> noteEntityPage=noteService.findAll(pageable);
        return noteEntityPage.map(noteMapper::mapTo);
    }
//    @GetMapping(path = "/Notes/{idNote}")
//    public ResponseEntity<NoteDto> getNote(@PathVariable Long idNote) {
//        Optional<NoteEntity> foundNote=noteService.findNoteById(idNote);
//        return foundNote.map(noteEntity -> {
//            NoteDto noteDto=noteMapper.mapTo(noteEntity);
//            return new ResponseEntity<>(noteDto, HttpStatus.OK);
//        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
    @PutMapping(path = "/Notes/{idNote}")
    public ResponseEntity<NoteDto> fullUpdateNoteById(@PathVariable Long idNote, @RequestBody NoteDto note) {
        if(noteService.isExist(idNote)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        note.setIdNote(idNote);
        NoteEntity noteEntity=noteMapper.mapFrom(note);
        NoteEntity savedNoteEntity=noteService.save(noteEntity);
        return new ResponseEntity<>(noteMapper.mapTo(savedNoteEntity), HttpStatus.OK);
    }
    @PatchMapping(path = "Notes/{idNote}")
    public ResponseEntity<NoteDto> updateNoteById(@PathVariable Long idNote, @RequestBody NoteDto note) {
        if(noteService.isExist(idNote)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        NoteEntity noteEntity=noteMapper.mapFrom(note);
        NoteEntity savedNoteEntity=noteService.partialUpdate(idNote, noteEntity);
        return new ResponseEntity<>(noteMapper.mapTo(savedNoteEntity), HttpStatus.OK);
    }
    @DeleteMapping(path = "Notes/{idNote}")
    public ResponseEntity<NoteDto> deleteNoteById(@PathVariable Long idNote) {
        if(noteService.isExist(idNote)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        noteService.deleteNote(idNote);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/Notes/{idEtudiant}")
    public List<NoteEntity> getNotesByEtudiantId(@PathVariable Long idEtudiant) {
        return noteService.findNotesByEtudiantId(idEtudiant);
    }
}
