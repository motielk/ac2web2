package com.example.agenda.services;

import com.example.agenda.dtos.AgendaDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendaService {
    void adicionar(AgendaDTO agendaDTO);
    void vincularProfessor(Integer idAgenda, Integer idProfessor, Integer idCurso);
    List<AgendaDTO> buscarAgenda(Integer idProfessor);
    List<AgendaDTO> listarAgendas();
    boolean verificarDisponibilidadeProfessor(Integer idCurso, LocalDateTime data);
    void cadastrarResumoTreinamento(Integer idProfessor, Integer idCurso, String resumo);
    void imprimirAgenda(Integer idProfessor);
}
