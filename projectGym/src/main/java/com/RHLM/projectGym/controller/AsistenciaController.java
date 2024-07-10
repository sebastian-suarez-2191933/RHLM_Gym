package com.RHLM.projectGym.controller;

import com.RHLM.projectGym.dto.AsistenciaDTO;
import com.RHLM.projectGym.mapper.AsistenciaMapper;
import com.RHLM.projectGym.model.Asistencia;
import com.RHLM.projectGym.services.interfaces.IAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
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


    //    NEWWWWWW
    @GetMapping("/findAsistenciaByFecha")
    public ResponseEntity<List<AsistenciaDTO>> findAsistenciaByFecha(@RequestParam("fechaLlegada") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaLlegada){
        List<Asistencia> asistenciaList = this.asistenciaService.findAsistenciaByFecha(fechaLlegada);
        if (asistenciaList == null || asistenciaList.isEmpty()){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(asistenciaList.stream()
                .map(AsistenciaMapper.INSTANCE::toAsistenciaDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    // NEW
    @GetMapping("/findAsistenciaByDocument")
    public ResponseEntity<List<AsistenciaDTO>> findAsistenciaByDocument(@RequestParam("identificacion") int identificacion){
        List<Asistencia> asistenciaList = this.asistenciaService.findAsistenciaByDocument(identificacion);
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
    public ResponseEntity<Map<String, Object>> createAsistencia(@RequestParam(value = "identificacion", required = true) int identificacion) {
        ResponseEntity<Map<String, Object>> respuestaServicio = this.asistenciaService.createAsistencia(identificacion);

        if (respuestaServicio.getStatusCode().is2xxSuccessful()) {
            Map<String, Object> respuesta = respuestaServicio.getBody();
            Asistencia asistencia = (Asistencia) respuesta.get("asistencia");
            long diasRestantes = (long) respuesta.get("diasRestantes");

            Map<String, Object> respuestaFinal = new HashMap<>();
            respuestaFinal.put("asistencia", AsistenciaMapper.INSTANCE.toAsistenciaDTO(asistencia));
            respuestaFinal.put("diasRestantes", diasRestantes);

            return ResponseEntity.ok(respuestaFinal);
        } else {
            return ResponseEntity.status(respuestaServicio.getStatusCode()).body(null);
        }
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
