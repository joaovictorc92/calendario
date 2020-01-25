package br.com.deveficiente.calendario.service;

import br.com.deveficiente.calendario.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenBuildService {

    @Value("${forum.jwt.expiration}")
    private String expiration;
    @Value("${forum.jwt.secret}")
    private String secret;


    public String gerarToken(Authentication authetication) {
        Date hoje = new Date();
        Date dataExpiraticao = new Date(hoje.getTime() + Long.parseLong(expiration));
        Usuario logado = (Usuario) authetication.getPrincipal();

        return Jwts.builder()
                .setIssuer("API do fórum da Alura")
                .setSubject(logado.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiraticao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isValido(String token) {

        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(body.getSubject());
    }
}
