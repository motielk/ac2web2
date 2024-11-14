package com.example.agenda.controllers;

import com.example.agenda.dtos.AgendaDTO;
import com.example.agenda.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping
    public void adicionar(@RequestBody AgendaDTO agenda) {
        agendaService.adicionar(agenda);
    }

    @PostMapping("/vincular")
    public void vincularProfessor(@RequestParam Integer idAgenda, @RequestParam Integer idProfessor, @RequestParam Integer idCurso) {
        agendaService.vincularProfessor(idAgenda, idProfessor, idCurso);
    }

    @GetMapping("/{idProfessor}")
    public List<AgendaDTO> buscarAgenda(@PathVariable Integer idProfessor) {
        return agendaService.buscarAgenda(idProfessor);
    }

    @GetMapping
    public List<AgendaDTO> listarAgendas() {
        return agendaService.listarAgendas();
    }

    @GetMapping("/disponibilidade")
    public boolean verificarDisponibilidadeProfessor(@RequestParam Integer idCurso, @RequestParam LocalDateTime data) {
        return agendaService.verificarDisponibilidadeProfessor(idCurso, data);
    }

    @PostMapping("/resumo")
    public void cadastrarResumoTreinamento(
            @RequestParam Integer idProfessor,
            @RequestParam Integer idCurso,
            @RequestParam String resumo) {
        agendaService.cadastrarResumoTreinamento(idProfessor, idCurso, resumo);
    }

    @GetMapping("/{idProfessor}/imprimir")
    public void imprimirAgenda(@PathVariable Integer idProfessor) {
        agendaService.imprimirAgenda(idProfessor);
    }
}
