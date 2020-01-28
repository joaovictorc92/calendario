package br.com.deveficiente.calendario.repository;

import br.com.deveficiente.calendario.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento,Long> {
}
