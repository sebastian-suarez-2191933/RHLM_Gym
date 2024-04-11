package com.RHLM.projectGym.services.impl;

import com.RHLM.projectGym.dto.PersonaDTO;
import com.RHLM.projectGym.exception.DataNotFoundException;
import com.RHLM.projectGym.mapper.PersonaMapper;
import com.RHLM.projectGym.model.Persona;
import com.RHLM.projectGym.repository.IPersonaRepository;
import com.RHLM.projectGym.services.interfaces.IPersonaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonaImpl implements IPersonaService {



    @Autowired
    private IPersonaRepository personaRepository;

    @Override
    public List<PersonaDTO> getAll() {
        List<Persona> rolesList = this.personaRepository.findAll();
        return rolesList.stream().map(PersonaMapper.INSTANCE::toPersonaDTO).collect(Collectors.toList());
    }


    @Override
    public PersonaDTO findById(Long id) {
        Persona personaFound = this.personaRepository.findById(id).orElseThrow(DataNotFoundException::new);
        return PersonaMapper.INSTANCE.toPersonaDTO(personaFound);
    }

    @Override
    public PersonaDTO createPersona(PersonaDTO personaDTO) {
        Persona data = PersonaMapper.INSTANCE.toPersona(personaDTO);
        Persona persona = this.personaRepository.save(data);
        return PersonaMapper.INSTANCE.toPersonaDTO(persona);
    }

    @Override
    public PersonaDTO updatePersona(Long id, PersonaDTO personaDTO) {
        Persona persona = this.personaRepository.findById(id).orElseThrow(DataNotFoundException::new);

        persona.setNombre(personaDTO.getNombre());
        persona.setFechanac(personaDTO.getFechanac());
        persona.setIdentificacion(personaDTO.getIdentificacion());

        Persona personaUptaded = this.personaRepository.save(persona);
        return PersonaMapper.INSTANCE.toPersonaDTO(personaUptaded);
    }

    @Override
    public void deletePersona(Long id){
        Persona persona = personaRepository.findById(id).orElseThrow(DataNotFoundException::new);
        this.personaRepository.deleteById(persona.getId());
    }
}
