package com.conteneurisation.project.mappers.impl;

import com.conteneurisation.project.config.MapperConfig;
import com.conteneurisation.project.domain.dto.NoteDto;
import com.conteneurisation.project.domain.entities.NoteEntity;
import com.conteneurisation.project.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class NoteMapperImpl implements Mapper<NoteDto,NoteEntity > {
    private final ModelMapper modelMapper ;
    public NoteMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public NoteDto mapTo(NoteEntity note) {
        return modelMapper.map(note, NoteDto.class);
    }

    @Override
    public NoteEntity mapFrom(NoteDto noteDto) {
        return modelMapper.map(noteDto, NoteEntity.class);
    }
}
