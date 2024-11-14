package com.example.agenda.services;

import com.example.agenda.dtos.ProfessorDTO;
import java.util.List;

public interface ProfessorService {
    void adicionar(ProfessorDTO professorDTO);
    List<ProfessorDTO> listarProfessores();
}
