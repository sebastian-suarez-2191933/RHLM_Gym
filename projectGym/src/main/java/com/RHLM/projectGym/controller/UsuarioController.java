package com.RHLM.projectGym.controller;

import com.RHLM.projectGym.dto.UsuarioDTO;
import com.RHLM.projectGym.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/getAll")
    public ResponseEntity<List<UsuarioDTO>> getAll(){
        List<UsuarioDTO> usuarios = this.usuarioService.getAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable Long id){
        UsuarioDTO usuarioFound = this.usuarioService.findById(id);
        return new ResponseEntity<>(usuarioFound, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return new ResponseEntity<>(usuarioService.createUsuario(usuarioDTO), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO){
        return new ResponseEntity<>(usuarioService.updateUsuario(id, usuarioDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteUsuario(@PathVariable Long id){
        this.usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
