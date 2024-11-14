package com.example.agenda.controllers;

import com.example.agenda.dtos.ProfessorDTO;
import com.example.agenda.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping()
    public void adicionar(@RequestBody ProfessorDTO professor) {
        professorService.adicionar(professor);
    }

    @GetMapping()
    public List<ProfessorDTO> listarProfessores() {
        return professorService.listarProfessores();
    }
}
