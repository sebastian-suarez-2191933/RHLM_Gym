package com.RHLM.projectGym.controller;

import com.RHLM.projectGym.dto.SuscripcionDTO;
import com.RHLM.projectGym.services.interfaces.ISuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("suscripcion")
public class SuscripcionController {

    @Autowired
    private ISuscripcionService suscripcionService;

    @GetMapping("/getAll")
    public ResponseEntity<List<SuscripcionDTO>> getAll(){
        List<SuscripcionDTO> suscripcionDTOList = this.suscripcionService.getAll();
        return new ResponseEntity<>(suscripcionDTOList, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<SuscripcionDTO> getById(@PathVariable Long id){
        SuscripcionDTO suscripcionFound = this.suscripcionService.findById(id);
        return new ResponseEntity<>(suscripcionFound, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<SuscripcionDTO> createSuscripcion(@RequestBody SuscripcionDTO suscripcionDTO){
        return new ResponseEntity<>(this.suscripcionService.createSuscripcion(suscripcionDTO), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SuscripcionDTO> updateSuscripcion(@PathVariable Long id, @RequestBody SuscripcionDTO suscripcionDTO){
        return new ResponseEntity<>(this.suscripcionService.updateSuscripcion(id, suscripcionDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteSuscripcion(@PathVariable Long id){
        this.suscripcionService.deleteSuscripcion(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
