package br.com.deveficiente.calendario.repository;

import br.com.deveficiente.calendario.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    @Query(value = "select * from evento " +
            "where (inicio between :dataInicial and :dataFinal) " +
            "or (fim between  :dataInicial and :dataFinal)", nativeQuery = true)
    public List<Evento> findEventosConflituosos(@Param("dataInicial") LocalDateTime dataInicial, @Param("dataFinal") LocalDateTime dataFinal);
}
