package com.RHLM.projectGym.controller;

import com.RHLM.projectGym.dto.RolesUsuarioDTO;
import com.RHLM.projectGym.services.interfaces.IRolesUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rolesUsuario")
public class RolesUsuarioController {

    @Autowired
    private IRolesUsuarioService rolesUsuarioService;

    @GetMapping("/getAll")
    public ResponseEntity<List<RolesUsuarioDTO>> getAll(){
        List<RolesUsuarioDTO> rolesUsuarioDTOS = this.rolesUsuarioService.getAll();
        return new ResponseEntity<>(rolesUsuarioDTOS, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<RolesUsuarioDTO> getById(@PathVariable Long id){
        RolesUsuarioDTO rolesFound = this.rolesUsuarioService.findById(id);
        return new ResponseEntity<>(rolesFound, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<RolesUsuarioDTO> createRolUsuario(@RequestBody RolesUsuarioDTO rolDTO){
        return new ResponseEntity<>(rolesUsuarioService.createRolUsuario(rolDTO), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RolesUsuarioDTO> updateRolUsuario(@PathVariable Long id, @RequestBody RolesUsuarioDTO rolDTO){
        return new ResponseEntity<>(rolesUsuarioService.updateRolUsuario(id, rolDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteRolUsuario(@PathVariable Long id){
        this.rolesUsuarioService.deleteRolUsuario(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
