package com.RHLM.projectGym.services.interfaces;

import com.RHLM.projectGym.dto.PersonaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonaService {


    List<PersonaDTO> getAll();

    PersonaDTO findById(Long id);

    PersonaDTO createPersona(PersonaDTO personaDTO);

    PersonaDTO updatePersona(Long id, PersonaDTO personaDTO);

    void deletePersona(Long id);
}
