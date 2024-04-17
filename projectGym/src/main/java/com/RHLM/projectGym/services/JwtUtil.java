package com.RHLM.projectGym.services;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.RHLM.projectGym.dto.AdminDTO;
import com.RHLM.projectGym.model.Admin;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    // Definir la clave segura con al menos 256 bits de longitud
    private static final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Obtener la clave secreta desde el archivo de propiedades
    @Value("${jwt.secret}")
    private String secretKey;

    public String generateAuthToken(AdminDTO admin) {
        // Crear el token JWT con el correo del administrador como sujeto del token y firmarlo con la clave segura definida
        String token = Jwts.builder()
                .setSubject(admin.getUsuario()) // Establecer el correo del administrador como sujeto del token
                .signWith(key) // Firmar el token con la clave segura definida
                .compact();

        return token;
    }
}
