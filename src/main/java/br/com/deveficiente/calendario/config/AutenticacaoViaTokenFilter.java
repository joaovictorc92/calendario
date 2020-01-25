package br.com.deveficiente.calendario.config;

import br.com.deveficiente.calendario.model.Usuario;
import br.com.deveficiente.calendario.repository.UsuarioRepository;
import br.com.deveficiente.calendario.service.TokenBuildService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

    private TokenBuildService tokenBuildService;
    private UsuarioRepository repository;

    public AutenticacaoViaTokenFilter(TokenBuildService tokenBuildService, UsuarioRepository repository) {
        this.tokenBuildService = tokenBuildService;
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String token = recuperarToken(httpServletRequest);
        boolean valido = tokenBuildService.isValido(token);
        if (valido) {
            autenticarCliente(token);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void autenticarCliente(String token) {
        Long idUsuario = tokenBuildService.getIdUsuario(token);
        Usuario usuario = repository.findById(idUsuario).get();
        Authentication athentication = new UsernamePasswordAuthenticationToken(usuario, null, null);
        SecurityContextHolder.getContext().setAuthentication(athentication);
    }

    private String recuperarToken(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        if(StringUtils.isBlank(token) || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }
}
