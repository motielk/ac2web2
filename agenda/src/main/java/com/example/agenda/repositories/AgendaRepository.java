package com.example.agenda.repositories;

import com.example.agenda.models.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {

    List<Agenda> findByProfessorId(Integer professorId);
    boolean existsByCursoIdAndHorario(Integer cursoId, LocalDateTime horario);
    Optional<Agenda> findByProfessorIdAndCursoId(Integer professorId, Integer cursoId);
}
