package br.upe.chatbotwpp.chatbotwpp.controlador;

import br.upe.chatbotwpp.chatbotwpp.dominio.Agendamento;
import br.upe.chatbotwpp.chatbotwpp.servico.AgendamentoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")

@RequiredArgsConstructor
public class AgendamentoControlador {

    private final AgendamentoServico agendamentoServico;

    @GetMapping
    public List<Agendamento> listar() {
        return agendamentoServico.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> listarPorId(@PathVariable("id") Long id) {
        Agendamento entity = agendamentoServico.findAgendamentoById(id);
        return ResponseEntity.ok(entity);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> atualizarPorId(@PathVariable Long id, @RequestParam boolean status) {
        agendamentoServico.atualizarPorId(id, status);
        return ResponseEntity.ok("Status de disponibilidade atualizado com sucesso.");
    }

    @GetMapping("/disponiveis")
    public List<Agendamento> listarDisponiveis() {
        return agendamentoServico.findDisponiveis();
    }

    @GetMapping("/disponiveis/{dia}")
    public ResponseEntity<List<Agendamento>> listarAgendamentosDisponiveisPorDia(@PathVariable String dia) {
        List<Agendamento> agendamentosDisponiveis = agendamentoServico.listarAgendamentosDisponiveisPorDia(dia);
        return ResponseEntity.ok(agendamentosDisponiveis);
    }

}
