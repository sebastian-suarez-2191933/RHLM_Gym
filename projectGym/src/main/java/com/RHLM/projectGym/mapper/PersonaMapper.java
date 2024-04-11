package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.PersonaDTO;
import com.RHLM.projectGym.model.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonaMapper {

    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    //DTO to Entity
    Persona toPersona(PersonaDTO personaDTO);

    //Entity to DTO
    PersonaDTO toPersonaDTO(Persona persona);
}
