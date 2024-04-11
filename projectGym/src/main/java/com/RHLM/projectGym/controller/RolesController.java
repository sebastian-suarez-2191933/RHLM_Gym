package com.RHLM.projectGym.controller;

import com.RHLM.projectGym.dto.RolesDTO;
import com.RHLM.projectGym.services.interfaces.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roles")
public class RolesController {

    @Autowired
    private IRolesService rolesService;

    @GetMapping("/getAll")
    public ResponseEntity<List<RolesDTO>> getAll(){
        List<RolesDTO> roles = this.rolesService.getAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<RolesDTO> getById(@PathVariable Long id){
        RolesDTO rolesFound = this.rolesService.findById(id);
        return new ResponseEntity<>(rolesFound, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<RolesDTO> createRol(@RequestBody RolesDTO rolDTO){
        return new ResponseEntity<>(rolesService.createRol(rolDTO), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RolesDTO> updateRol(@PathVariable Long id, @RequestBody RolesDTO rolDTO){
        return new ResponseEntity<>(rolesService.updateRol(id, rolDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteRol(@PathVariable Long id){
        this.rolesService.deleteRol(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
