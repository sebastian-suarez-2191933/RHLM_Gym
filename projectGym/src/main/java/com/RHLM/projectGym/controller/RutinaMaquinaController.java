package com.RHLM.projectGym.controller;

import com.RHLM.projectGym.dto.RutinaMaquinaDTO;
import com.RHLM.projectGym.mapper.RutinaMaquinaMapper;
import com.RHLM.projectGym.model.Rutina;
import com.RHLM.projectGym.model.RutinaMaquina;
import com.RHLM.projectGym.services.interfaces.IRutinaMaquinaService;
import com.RHLM.projectGym.services.interfaces.IRutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rutinaMaquina")
public class RutinaMaquinaController {

    @Autowired
    private IRutinaMaquinaService rutinaMaquinaService;

    @GetMapping("/getAllRutinaMaquina")
    public ResponseEntity<List<RutinaMaquinaDTO>> getAllRutinaMaquina(){
        List<RutinaMaquina> rutinaMaquinaList = this.rutinaMaquinaService.getAll();
        if (rutinaMaquinaList == null || rutinaMaquinaList.isEmpty()){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(rutinaMaquinaList.stream()
                .map(RutinaMaquinaMapper.INSTANCE::toRutinaMaquinaDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutinaMaquinaDTO> getRutinaMaquinaById(@PathVariable(value = "id") Long id){
        RutinaMaquina rutinaMaquina = this.rutinaMaquinaService.getRutinaMaquinaById(id);
        if (rutinaMaquina == null){
            return new ResponseEntity<>(new RutinaMaquinaDTO(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RutinaMaquinaMapper.INSTANCE.toRutinaMaquinaDTO(rutinaMaquina), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RutinaMaquinaDTO> createRutinaMaquina(@RequestBody RutinaMaquinaDTO rutinaMaquinaDTO){
        RutinaMaquina rutinaMaquina = RutinaMaquinaMapper.INSTANCE.toRutinaMaquina(rutinaMaquinaDTO);
        var rutinaMaquinaBD = this.rutinaMaquinaService.createRutinaMaquina(rutinaMaquina);
        if (rutinaMaquinaBD == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(RutinaMaquinaMapper.INSTANCE.toRutinaMaquinaDTO(rutinaMaquinaBD), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RutinaMaquinaDTO> updateRutinaMaquina(@RequestBody RutinaMaquinaDTO rutinaMaquinaDTO){
        RutinaMaquina rutinaMaquina = RutinaMaquinaMapper.INSTANCE.toRutinaMaquina(rutinaMaquinaDTO);
        var rutinaMaquinaBD = this.rutinaMaquinaService.updateRutinaMaquina(rutinaMaquina);
        if (rutinaMaquinaBD == null){
            return new ResponseEntity<>(new RutinaMaquinaDTO(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RutinaMaquinaMapper.INSTANCE.toRutinaMaquinaDTO(rutinaMaquinaBD), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRutinaMaquina(@PathVariable(value = "id")Long id){
        this.rutinaMaquinaService.deleteRutinaMaquinaById(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }

}
