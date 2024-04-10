package com.RHLM.projectGym.controller;


import com.RHLM.projectGym.dto.RutinaDTO;
import com.RHLM.projectGym.mapper.RutinaMapper;
import com.RHLM.projectGym.model.Rutina;
import com.RHLM.projectGym.services.interfaces.IRutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rutina")
public class RutinaController {

    @Autowired
    private IRutinaService rutinaService;

    @GetMapping("/getAllRutina")
    public ResponseEntity<List<RutinaDTO>> getAllRutina(){
        List<Rutina> rutinaList = this.rutinaService.getAll();
        if (rutinaList == null || rutinaList.isEmpty()){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(rutinaList.stream()
                .map(RutinaMapper.INSTANCE::toRutinaDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutinaDTO> findRutinaById(@PathVariable(value = "id") Long id){
        Rutina rutina = this.rutinaService.findRutinaById(id);
        if (rutina == null){
            return new ResponseEntity<>(new RutinaDTO(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RutinaMapper.INSTANCE.toRutinaDTO(rutina), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RutinaDTO> createRutina(@RequestBody RutinaDTO rutinaDTO){
        Rutina rutina = RutinaMapper.INSTANCE.toRutina(rutinaDTO);
        var rutinaBD = this.rutinaService.createRutina(rutina);
        if (rutinaBD == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(RutinaMapper.INSTANCE.toRutinaDTO(rutinaBD), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RutinaDTO> updateRutina(@RequestBody RutinaDTO rutinaDTO){
        Rutina rutina = RutinaMapper.INSTANCE.toRutina(rutinaDTO);
        var rutinaBD = this.rutinaService.updateRutina(rutina);
        if (rutinaBD == null){
            return new ResponseEntity<>(new RutinaDTO(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RutinaMapper.INSTANCE.toRutinaDTO(rutinaBD), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRutina(@PathVariable(value = "id") Long id){
        this.rutinaService.deleteRutinaById(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
