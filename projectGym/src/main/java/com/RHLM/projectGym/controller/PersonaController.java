package com.RHLM.projectGym.controller;

import com.RHLM.projectGym.dto.PersonaDTO;
import com.RHLM.projectGym.services.interfaces.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {


    @Autowired
    private IPersonaService personaService;

    @GetMapping("/getAll")
    public ResponseEntity<List<PersonaDTO>> getAll(){
        List<PersonaDTO> personas = this.personaService.getAll();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<PersonaDTO> getById(@PathVariable Long id){
        PersonaDTO personaFound = this.personaService.findById(id);
        return new ResponseEntity<>(personaFound, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<PersonaDTO> createPersona(@RequestBody PersonaDTO personaDTO){
        return new ResponseEntity<>(personaService.createPersona(personaDTO), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonaDTO> updatePersona(@PathVariable Long id, @RequestBody PersonaDTO personaDTO){
        return new ResponseEntity<>(personaService.updatePersona(id, personaDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deletePersona(@PathVariable Long id){
        this.personaService.deletePersona(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
