package br.com.deveficiente.calendario.repository;

import br.com.deveficiente.calendario.model.ConvidadoEvento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConvidadoEventoRepository extends JpaRepository<ConvidadoEvento, Long> {
    List<ConvidadoEvento> findByEvento_Id(Long codEvento);
}
