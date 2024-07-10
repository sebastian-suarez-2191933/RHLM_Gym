package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.PersonaDTO;
import com.RHLM.projectGym.model.Persona;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-09T00:43:04-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class PersonaMapperImpl implements PersonaMapper {

    @Override
    public Persona toPersona(PersonaDTO personaDTO) {
        if ( personaDTO == null ) {
            return null;
        }

        Persona persona = new Persona();

        persona.setId( personaDTO.getId() );
        persona.setNombre( personaDTO.getNombre() );
        persona.setFechanac( personaDTO.getFechanac() );
        if ( personaDTO.getIdentificacion() != null ) {
            persona.setIdentificacion( personaDTO.getIdentificacion() );
        }

        return persona;
    }

    @Override
    public PersonaDTO toPersonaDTO(Persona persona) {
        if ( persona == null ) {
            return null;
        }

        PersonaDTO personaDTO = new PersonaDTO();

        personaDTO.setId( persona.getId() );
        personaDTO.setNombre( persona.getNombre() );
        personaDTO.setFechanac( persona.getFechanac() );
        personaDTO.setIdentificacion( persona.getIdentificacion() );

        return personaDTO;
    }
}
