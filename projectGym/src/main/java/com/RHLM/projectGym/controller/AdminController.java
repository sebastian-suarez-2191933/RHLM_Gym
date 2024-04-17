package com.RHLM.projectGym.controller;

import com.RHLM.projectGym.dto.AdminDTO;
import com.RHLM.projectGym.model.Admin;
import com.RHLM.projectGym.services.JwtUtil;
import com.RHLM.projectGym.services.interfaces.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @GetMapping("/getAll")
    public ResponseEntity<List<AdminDTO>> getAll(){
        List<AdminDTO> admins = this.adminService.getAll();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<AdminDTO> getById(@PathVariable Long id){
        AdminDTO adminFound = this.adminService.findById(id);
        return new ResponseEntity<>(adminFound, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<AdminDTO> createAdmin(@RequestBody AdminDTO adminDTO){
        return new ResponseEntity<>(adminService.createAdmin(adminDTO), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AdminDTO> updateAdmin(@PathVariable Long id, @RequestBody AdminDTO adminDTO){
        return new ResponseEntity<>(adminService.updateAdmin(id, adminDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteAdmin(@PathVariable Long id){
        this.adminService.deleteAdmin(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AdminDTO adminDTO) {
    // Verificar si las credenciales son válidas
        AdminDTO admin = adminService.findByUsuario(adminDTO.getUsuario());
        if (admin != null && admin.getContra().equals(adminDTO.getContra())) {
        // Si las credenciales son válidas, generar un token de autenticación
            String token = jwtUtil.generateAuthToken(admin);
        // Devolver el token en la respuesta
            return ResponseEntity.ok(token);
        } else {
        // Si las credenciales no son válidas, devolver un mensaje de error
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }

}
