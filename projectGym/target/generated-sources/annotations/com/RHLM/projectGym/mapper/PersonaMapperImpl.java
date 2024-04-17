package com.RHLM.projectGym.mapper;

import com.RHLM.projectGym.dto.PersonaDTO;
import com.RHLM.projectGym.model.Persona;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T22:34:08-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class PersonaMapperImpl implements PersonaMapper {

    @Override
    public Persona toPersona(PersonaDTO personaDTO) {
        if ( personaDTO == null ) {
            return null;
        }

        Persona persona = new Persona();

        persona.setFechanac( personaDTO.getFechanac() );
        persona.setId( personaDTO.getId() );
        if ( personaDTO.getIdentificacion() != null ) {
            persona.setIdentificacion( personaDTO.getIdentificacion() );
        }
        persona.setNombre( personaDTO.getNombre() );

        return persona;
    }

    @Override
    public PersonaDTO toPersonaDTO(Persona persona) {
        if ( persona == null ) {
            return null;
        }

        PersonaDTO personaDTO = new PersonaDTO();

        personaDTO.setFechanac( persona.getFechanac() );
        personaDTO.setId( persona.getId() );
        personaDTO.setIdentificacion( persona.getIdentificacion() );
        personaDTO.setNombre( persona.getNombre() );

        return personaDTO;
    }
}
