package br.com.deveficiente.calendario.repository;

import br.com.deveficiente.calendario.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
}
