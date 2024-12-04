package com.conteneurisation.project.mappers.impl;

import com.conteneurisation.project.domain.dto.EtudiantDto;
import com.conteneurisation.project.domain.entities.EtudiantEntity;
import com.conteneurisation.project.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EtudiantMapperImpl implements Mapper<EtudiantDto, EtudiantEntity> {
    private final ModelMapper modelMapper ;
    public EtudiantMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public EtudiantDto mapTo(EtudiantEntity etudiantEntity) {
        return modelMapper.map(etudiantEntity, EtudiantDto.class);
    }

    @Override
    public EtudiantEntity mapFrom(EtudiantDto etudiantDto) {
        return modelMapper.map(etudiantDto,EtudiantEntity.class);
    }
}
