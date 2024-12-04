package com.conteneurisation.project.repositories;

import com.conteneurisation.project.domain.entities.EtudiantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EtudiantRepository extends JpaRepository<EtudiantEntity,Long>, PagingAndSortingRepository<EtudiantEntity,Long> {

}
