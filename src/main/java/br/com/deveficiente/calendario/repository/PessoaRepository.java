package br.com.deveficiente.calendario.repository;

import br.com.deveficiente.calendario.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
