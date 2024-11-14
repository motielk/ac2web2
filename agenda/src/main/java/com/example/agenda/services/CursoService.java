package com.example.agenda.services;

import com.example.agenda.dtos.CursoDTO;
import java.util.List;

public interface CursoService {
    void adicionar(CursoDTO cursoDTO);
    List<CursoDTO> listarCursos();
}
