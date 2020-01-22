package br.com.deveficiente.calendario.repository;

import br.com.deveficiente.calendario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findAll();
}
