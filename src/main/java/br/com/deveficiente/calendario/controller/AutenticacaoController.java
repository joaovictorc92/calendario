package br.com.deveficiente.calendario.controller;

import br.com.deveficiente.calendario.controller.form.LoginForm;
import br.com.deveficiente.calendario.dto.TokenDto;
import br.com.deveficiente.calendario.service.TokenBuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private TokenBuildService tokenService;

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form){
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();

        try{
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token =  tokenService.gerarToken(authentication);

            return ResponseEntity.ok(new TokenDto(token, "Bearer"));

        }catch (AuthenticationException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }


    }
}
