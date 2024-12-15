package com.conteneurisation.project.controllers;

import com.conteneurisation.project.domain.dto.EtudiantDto;
import com.conteneurisation.project.domain.entities.EtudiantEntity;
import com.conteneurisation.project.mappers.impl.EtudiantMapperImpl;
import com.conteneurisation.project.services.EtudiantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
public class EtudiantController {
    private final EtudiantService etudiantService;
    private final EtudiantMapperImpl etudiantMapper;
    public EtudiantController(EtudiantService etudiantService, EtudiantMapperImpl etudiantMapper) {
        this.etudiantService = etudiantService;
        this.etudiantMapper = etudiantMapper;
    }


    @PostMapping(path = "/Etudiants")
    public EtudiantDto addEtudiant(@RequestBody EtudiantDto etudiant) {
        EtudiantEntity etudiantEntity = etudiantMapper.mapFrom(etudiant);
        EtudiantEntity savedEtudiantEntity = etudiantService.save(etudiantEntity);
        return etudiantMapper.mapTo(savedEtudiantEntity);
    }
    @GetMapping(path = "/Etudiants")
    public Page<EtudiantDto> getAllEtudiants(Pageable pageable) {
        Page<EtudiantEntity> etudiants = etudiantService.findAll(pageable);
        return etudiants.map(etudiantMapper::mapTo);
    }
    @GetMapping(path = "/Etudiants/{idEtudiant}")
    public ResponseEntity<EtudiantDto> getEtudiantById(@PathVariable Long idEtudiant) {
        Optional<EtudiantEntity> foundEtudiant=etudiantService.findEtudiantById(idEtudiant);
        return foundEtudiant.map(etudiantEntity->{
             EtudiantDto etudiantDto= etudiantMapper.mapTo(etudiantEntity);
             return new ResponseEntity<>(etudiantDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping(path = "/Etudiants/{idEtudiant}" )
    public ResponseEntity<EtudiantDto> fullUpdateEtudiantById(@PathVariable Long idEtudiant,@RequestBody EtudiantDto etudiantDto) {
        if(!etudiantService.isexists(idEtudiant)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        etudiantDto.setIdEtudiant(idEtudiant);
        EtudiantEntity etudiantEntity = etudiantMapper.mapFrom(etudiantDto);
        EtudiantEntity savedEtudiantEntity = etudiantService.save(etudiantEntity);
        return new ResponseEntity<>(etudiantMapper.mapTo(savedEtudiantEntity), HttpStatus.OK);
    }

    @PatchMapping(path = "/Etudiants/{idEtudiant}")
    public ResponseEntity<EtudiantDto> updateEtudiantByUd(@PathVariable Long idEtudiant,@RequestBody EtudiantDto etudiant) {
        if(!etudiantService.isexists(idEtudiant)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        EtudiantEntity etudiantEntity = etudiantMapper.mapFrom(etudiant);
        EtudiantEntity savedEtudiantEntity = etudiantService.partialUpdate(idEtudiant,etudiantEntity);
        return new ResponseEntity<>(etudiantMapper.mapTo(savedEtudiantEntity), HttpStatus.OK);
    }
    @DeleteMapping(path ="/Etudiants/{idEtudiant}" )
    public ResponseEntity<String> deleteEtudiantById(@PathVariable Long idEtudiant) {
        if(!etudiantService.isexists(idEtudiant)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        etudiantService.deleteEtudiant(idEtudiant);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
