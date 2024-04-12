package com.RHLM.projectGym.controller;

import com.RHLM.projectGym.dto.AsistenciaDTO;
import com.RHLM.projectGym.mapper.AsistenciaMapper;
import com.RHLM.projectGym.model.Asistencia;
import com.RHLM.projectGym.services.interfaces.IAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {

    @Autowired
    private IAsistenciaService asistenciaService;

    @GetMapping("/getAllAsistencia")
    public ResponseEntity<List<AsistenciaDTO>> getAllAsistencia(){
        List<Asistencia> asistenciaList = this.asistenciaService.getAll();
        if (asistenciaList == null || asistenciaList.isEmpty()){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(asistenciaList.stream()
                .map(AsistenciaMapper.INSTANCE::toAsistenciaDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsistenciaDTO> getAsistenciaById(@PathVariable(value = "id") Long id){
        Asistencia asistencia = this.asistenciaService.getAsistenciaById(id);
        if (asistencia == null){
            return new ResponseEntity<>(new AsistenciaDTO(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(AsistenciaMapper.INSTANCE.toAsistenciaDTO(asistencia), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AsistenciaDTO> createAsistencia(@RequestBody AsistenciaDTO asistenciaDTO){
        Asistencia asistencia = AsistenciaMapper.INSTANCE.toAsistencia(asistenciaDTO);
        var asistenciaBD = this.asistenciaService.createAsistencia(asistencia);
        if (asistenciaBD == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(AsistenciaMapper.INSTANCE.toAsistenciaDTO(asistenciaBD), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AsistenciaDTO> updateAsistencia(@RequestBody AsistenciaDTO asistenciaDTO){
        Asistencia asistencia = AsistenciaMapper.INSTANCE.toAsistencia(asistenciaDTO);
        var asistenciaBD = this.asistenciaService.updateAsistencia(asistencia);
        if (asistenciaBD == null){
            return new ResponseEntity<>(new AsistenciaDTO(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(AsistenciaMapper.INSTANCE.toAsistenciaDTO(asistenciaBD), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAsistencia(@PathVariable(value = "id") Long id){
        this.asistenciaService.deleteAsistenciaById(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
