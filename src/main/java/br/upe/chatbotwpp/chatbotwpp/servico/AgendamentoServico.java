package br.upe.chatbotwpp.chatbotwpp.servico;

import br.upe.chatbotwpp.chatbotwpp.dominio.Agendamento;
import br.upe.chatbotwpp.chatbotwpp.repositorio.AgendamentoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

@RequiredArgsConstructor
public class AgendamentoServico {

    private final AgendamentoRepositorio agendamentoRepositorio;

    public Agendamento findAgendamentoById(Long id) {
        return agendamentoRepositorio.findById(id).get();
    }

    public List<Agendamento> findAll() {
        return agendamentoRepositorio.findAll();
    }

    public void atualizarPorId(Long id, boolean status) {
        Agendamento agendamento = agendamentoRepositorio.findById(id).orElseThrow();

        agendamento.setStatus(status);
        agendamentoRepositorio.save(agendamento);
    }

    public List<Agendamento> findDisponiveis() {
        return agendamentoRepositorio.findByStatus(true);
    }

    public List<Agendamento> listarAgendamentosDisponiveisPorDia(String dia) {
        return agendamentoRepositorio.findByDiaAndStatus(dia, true);
    }
}
