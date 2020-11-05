package com.lluis.ServiGest.seguridad.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.lluis.ServiGest.pojos.Usuario;

import java.util.Date;

@Component
@Slf4j
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    // Generador del Token
    public String generateToken(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuario.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    // Obtiene nombre de Usuario por Token dado
    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    // Validador del Token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            log.error("token mal formado " +e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("token no soportado " +e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("token expirado " +e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("token vacío " +e.getMessage());
        } catch (SignatureException e) {
            log.error("error en la firma " +e.getMessage());
        }
        return false;
    }
}
