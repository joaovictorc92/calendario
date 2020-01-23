package br.com.deveficiente.calendario.repository;

import br.com.deveficiente.calendario.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda,Long> {
}
