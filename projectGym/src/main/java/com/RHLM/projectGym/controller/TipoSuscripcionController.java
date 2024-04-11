package com.RHLM.projectGym.controller;

import com.RHLM.projectGym.dto.TipoSuscripcionDTO;
import com.RHLM.projectGym.services.interfaces.ITipoSuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tipoSuscripcion")
public class TipoSuscripcionController {

    @Autowired
    private ITipoSuscripcionService tipoSuscripcionService;

    @GetMapping("/getAll")
    public ResponseEntity<List<TipoSuscripcionDTO>> getAll(){
        List<TipoSuscripcionDTO> tipoSuscripcionDTOS = this.tipoSuscripcionService.getAll();
        return new ResponseEntity<>(tipoSuscripcionDTOS, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<TipoSuscripcionDTO> getById(@PathVariable Long id){
        TipoSuscripcionDTO tipoSuscripcionFound = this.tipoSuscripcionService.findById(id);
        return new ResponseEntity<>(tipoSuscripcionFound, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TipoSuscripcionDTO> createTipo(@RequestBody TipoSuscripcionDTO tipoSuscripcionDTO){
        return new ResponseEntity<>(this.tipoSuscripcionService.createTipo(tipoSuscripcionDTO), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TipoSuscripcionDTO> updateTipo(@PathVariable Long id, @RequestBody TipoSuscripcionDTO tipoSuscripcionDTO){
        return new ResponseEntity<>(this.tipoSuscripcionService.updateTipo(id, tipoSuscripcionDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteTipo(@PathVariable Long id){
        this.tipoSuscripcionService.deleteTipo(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

}
