package com.conteneurisation.project.services.impl;

import com.conteneurisation.project.domain.entities.EtudiantEntity;
import com.conteneurisation.project.repositories.EtudiantRepository;
import com.conteneurisation.project.services.EtudiantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepository etudiantRepository;
    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }
    @Override
    public EtudiantEntity save(EtudiantEntity etudiantEntity) {
        return etudiantRepository.save(etudiantEntity);
    }

    @Override
    public List<EtudiantEntity> findAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Page<EtudiantEntity> findAll(Pageable pageable) {
        return etudiantRepository.findAll(pageable);
    }

    @Override
    public Optional<EtudiantEntity> findEtudiantById(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant);
    }

    @Override
    public boolean isexists(Long idEtudiant) {
        return etudiantRepository.existsById(idEtudiant);
    }

    @Override
    public EtudiantEntity partialUpdate(Long idEtudiant, EtudiantEntity etudiantEntity) {
        etudiantEntity.setIdEtudiant(idEtudiant);
        return etudiantRepository.findById(idEtudiant).map(existingEtudiant -> {
            Optional.ofNullable(etudiantEntity.getName()).ifPresent(existingEtudiant::setName);
            return etudiantRepository.save(existingEtudiant);
        }).orElseThrow(() -> new RuntimeException("Etudiant not found"));
    }
    @Override
    public void deleteEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}