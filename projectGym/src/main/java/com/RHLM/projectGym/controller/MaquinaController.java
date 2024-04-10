package com.RHLM.projectGym.controller;

import com.RHLM.projectGym.dto.MaquinaDTO;
import com.RHLM.projectGym.mapper.MaquinaMapper;
import com.RHLM.projectGym.model.Maquina;
import com.RHLM.projectGym.model.Persona;
import com.RHLM.projectGym.services.interfaces.IMaquinaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.websocket.servlet.UndertowWebSocketServletWebServerCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/maquina")
public class MaquinaController {
    @Autowired
    private IMaquinaService maquinaService;

    @GetMapping("/getAllMaquina")
    public ResponseEntity<List<MaquinaDTO>> getAllMaquina(){
        List<Maquina> maquinaList= this.maquinaService.getAll();
        if(maquinaList == null || maquinaList.isEmpty()){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(maquinaList.stream()
                .map(MaquinaMapper.INSTANCE::toMaquinaDTO).collect(Collectors.toList()), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MaquinaDTO> findMaquinaById(@PathVariable(value = "id") Long id){
        Maquina maquina = this.maquinaService.findMaquinaById(id);
        if (maquina == null){
            return new ResponseEntity<>(new MaquinaDTO(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(MaquinaMapper.INSTANCE.toMaquinaDTO(maquina), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MaquinaDTO> createMaquina(@RequestBody MaquinaDTO maquinaDTO){
        Maquina maquina = MaquinaMapper.INSTANCE.toMaquina(maquinaDTO);
        var maquinaBD = this.maquinaService.createMaquina(maquina);
        if (maquinaBD == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(MaquinaMapper.INSTANCE.toMaquinaDTO(maquinaBD), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MaquinaDTO> updateMaquina(@RequestBody MaquinaDTO maquinaDTO){
        Maquina maquina = MaquinaMapper.INSTANCE.toMaquina(maquinaDTO);
        var maquinaBD = this.maquinaService.updateMaquina(maquina);
        if (maquinaBD == null){
            return new ResponseEntity<>(new MaquinaDTO(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(MaquinaMapper.INSTANCE.toMaquinaDTO(maquinaBD), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMaquina(@PathVariable(value = "id") Long id){
        this.maquinaService.deleteMaquinaById(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }

}
