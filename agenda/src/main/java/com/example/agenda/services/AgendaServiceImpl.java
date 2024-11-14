package com.example.agenda.services;

import com.example.agenda.dtos.AgendaDTO;
import com.example.agenda.models.Agenda;
import com.example.agenda.models.Curso;
import com.example.agenda.models.Professor;
import com.example.agenda.repositories.AgendaRepository;
import com.example.agenda.repositories.CursoRepository;
import com.example.agenda.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void adicionar(AgendaDTO agendaDTO) {
        Agenda agenda = new Agenda();

        agenda.setData(agendaDTO.data());
        agenda.setHorario(agendaDTO.horario());
        agenda.setCidade(agendaDTO.cidade());
        agenda.setUf(agendaDTO.uf());
        agenda.setCep(agendaDTO.cep());
        agenda.setResumo(agendaDTO.resumo());

        agendaRepository.save(agenda);
    }

    @Override
    public void vincularProfessor(Integer idAgenda, Integer idProfessor, Integer idCurso) {
        Agenda agenda = agendaRepository.findById(idAgenda)
                .orElseThrow(() -> new RuntimeException("Agenda não encontrada"));

        Professor professor = professorRepository.findById(idProfessor)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        Curso curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        if (!curso.getProfessores().contains(professor)) {

            curso.getProfessores().add(professor);
        }

        agenda.setProfessor(professor);
        agenda.setCurso(curso);

        agendaRepository.save(agenda);
    }




    @Override
    public List<AgendaDTO> buscarAgenda(Integer idProfessor) {
        return agendaRepository.findByProfessorId(idProfessor).stream()
                .map(agenda -> new AgendaDTO(
                        agenda.getData(),
                        agenda.getHorario(),
                        agenda.getCidade(),
                        agenda.getUf(),
                        agenda.getCep(),
                        agenda.getResumo()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AgendaDTO> listarAgendas() {
        return agendaRepository.findAll().stream()
                .map(agenda -> new AgendaDTO(
                        agenda.getData(),
                        agenda.getHorario(),
                        agenda.getCidade(),
                        agenda.getUf(),
                        agenda.getCep(),
                        agenda.getResumo()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean verificarDisponibilidadeProfessor(Integer idCurso, LocalDateTime data) {
        return agendaRepository.existsByCursoIdAndHorario(idCurso, data);
    }

    @Override
    public void cadastrarResumoTreinamento(Integer idProfessor, Integer idCurso, String resumo) {
        Agenda agenda = agendaRepository.findByProfessorIdAndCursoId(idProfessor, idCurso)
                .orElseThrow(() -> new RuntimeException("Agenda não encontrada"));

        agenda.setResumo(resumo);
        agendaRepository.save(agenda);
    }

    @Override
    public void imprimirAgenda(Integer idProfessor) {
        List<Agenda> agendas = agendaRepository.findByProfessorId(idProfessor);
        agendas.forEach(System.out::println);
    }
}
