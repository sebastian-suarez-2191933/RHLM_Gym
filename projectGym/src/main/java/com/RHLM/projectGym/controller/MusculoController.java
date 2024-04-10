package com.RHLM.projectGym.controller;


import com.RHLM.projectGym.dto.MaquinaDTO;
import com.RHLM.projectGym.dto.MusculoDTO;
import com.RHLM.projectGym.mapper.MaquinaMapper;
import com.RHLM.projectGym.mapper.MusculoMapper;
import com.RHLM.projectGym.model.Musculo;
import com.RHLM.projectGym.services.interfaces.IMaquinaService;
import com.RHLM.projectGym.services.interfaces.IMusculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("musculo")
public class MusculoController {

    @Autowired
    private IMusculoService musculoService;

    @GetMapping("/getAllMusculo")
    public ResponseEntity<List<MusculoDTO>> getAllMusculo(){
        List<Musculo> musculoList= this.musculoService.getAll();
        if (musculoList == null || musculoList.isEmpty()){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(musculoList.stream()
                .map(MusculoMapper.INSTANCE::toMusculoDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusculoDTO> findMusculoById(@PathVariable(value = "id") Long id){
        Musculo musculo = this.musculoService.findMusculoById(id);
        if (musculo == null){
            return new ResponseEntity<>(new MusculoDTO(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(MusculoMapper.INSTANCE.toMusculoDTO(musculo), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<MusculoDTO> createMusculo(@RequestBody MusculoDTO musculoDTO){
        Musculo musculo = MusculoMapper.INSTANCE.toMusculo(musculoDTO);
        var musculoBD = this.musculoService.createMusculo(musculo);
        if (musculoBD == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(MusculoMapper.INSTANCE.toMusculoDTO(musculoBD), HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<MusculoDTO> updateMusculo(@RequestBody MusculoDTO musculoDTO){
        Musculo musculo = MusculoMapper.INSTANCE.toMusculo(musculoDTO);
        var musculoBD = this.musculoService.updateMusculo(musculo);
        if (musculoBD == null){
            return new ResponseEntity<>(new MusculoDTO(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(MusculoMapper.INSTANCE.toMusculoDTO(musculoBD), HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deletePersona(@PathVariable(value = "id") Long id){
        this.musculoService.deleteMusculoById(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
