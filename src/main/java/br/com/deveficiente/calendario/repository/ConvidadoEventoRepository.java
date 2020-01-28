package br.com.deveficiente.calendario.repository;

import br.com.deveficiente.calendario.model.ConvidadoEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvidadoEventoRepository extends JpaRepository<ConvidadoEvento, Long> {
}
