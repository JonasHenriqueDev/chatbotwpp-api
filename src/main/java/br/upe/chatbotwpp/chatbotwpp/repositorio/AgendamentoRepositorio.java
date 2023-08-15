package br.upe.chatbotwpp.chatbotwpp.repositorio;

import br.upe.chatbotwpp.chatbotwpp.dominio.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendamentoRepositorio extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByStatus(boolean status);

    List<Agendamento> findByDiaAndStatus(String dia, boolean status);
}
