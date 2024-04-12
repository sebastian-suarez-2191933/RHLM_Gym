package com.RHLM.projectGym.controller;

import com.RHLM.projectGym.dto.MaquinaMusculoDTO;
import com.RHLM.projectGym.mapper.MaquinaMapper;
import com.RHLM.projectGym.mapper.MaquinaMusculoMapper;
import com.RHLM.projectGym.model.MaquinaMusculo;
import com.RHLM.projectGym.services.interfaces.IMaquinaMusculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/maquinaMusculo")
public class MaquinaMusculoController {

    @Autowired
    private IMaquinaMusculoService maquinaMusculoService;

    @GetMapping("/getAllMaquinaMusculo")
    public ResponseEntity<List<MaquinaMusculoDTO>> getAllMaquinaMusculo(){
        List<MaquinaMusculo> maquinaMusculoList = this.maquinaMusculoService.getAll();
        if (maquinaMusculoList == null || maquinaMusculoList.isEmpty()){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(maquinaMusculoList.stream()
                .map(MaquinaMusculoMapper.INSTANCE::toMaquinaMusculoDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaquinaMusculoDTO> getMaquinaMusculoById(@PathVariable(value = "id") Long id){
        MaquinaMusculo maquinaMusculo = this.maquinaMusculoService.findMaquinaMusculoById(id);
        if (maquinaMusculo == null){
            return new ResponseEntity<>(new MaquinaMusculoDTO(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(MaquinaMusculoMapper.INSTANCE.toMaquinaMusculoDTO(maquinaMusculo), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MaquinaMusculoDTO> createMaquinaMusculo(@RequestBody MaquinaMusculoDTO maquinaMusculoDTO){
        MaquinaMusculo maquinaMusculo = MaquinaMusculoMapper.INSTANCE.toMaquinaMusculo(maquinaMusculoDTO);
        var maquinaMusculoBD = this.maquinaMusculoService.createMaquinaMusculo(maquinaMusculo);
        if (maquinaMusculoBD == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(MaquinaMusculoMapper.INSTANCE.toMaquinaMusculoDTO(maquinaMusculoBD), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MaquinaMusculoDTO> updateMaquinaMusculo(@RequestBody MaquinaMusculoDTO maquinaMusculoDTO){
        MaquinaMusculo maquinaMusculo = MaquinaMusculoMapper.INSTANCE.toMaquinaMusculo(maquinaMusculoDTO);
        var maquinaMusculoBD = this.maquinaMusculoService.updateMaquinaMusculo(maquinaMusculo);
        if (maquinaMusculoBD == null){
            return new ResponseEntity<>(new MaquinaMusculoDTO(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(MaquinaMusculoMapper.INSTANCE.toMaquinaMusculoDTO(maquinaMusculoBD), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMaquinaMusculo(@PathVariable(value = "id") Long id){
        this.maquinaMusculoService.deleteMaquinaMusculoById(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
