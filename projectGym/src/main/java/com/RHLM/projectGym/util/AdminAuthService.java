package com.RHLM.projectGym.util;

import com.RHLM.projectGym.model.Admin;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AdminAuthService {

    // Método para generar el token de autenticación utilizando JWT
    private String generateAuthToken(Admin admin) {
        // Clave secreta para firmar el token (debes guardarla de manera segura)
        String secretKey = "clave-secreta";

        // Crear el token JWT con el correo del administrador como sujeto del token y firmarlo con el algoritmo HS256
        @SuppressWarnings("deprecation")
        String token = Jwts.builder()
                .setSubject(admin.getCorreo()) // Establecer el correo del administrador como sujeto del token
                .signWith(SignatureAlgorithm.HS256, secretKey) // Firmar el token con la clave secreta y el algoritmo HS256
                .compact();

        return token;
    }
}
