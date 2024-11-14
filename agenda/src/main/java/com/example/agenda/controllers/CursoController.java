package com.example.agenda.controllers;

import com.example.agenda.dtos.CursoDTO;
import com.example.agenda.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public void adicionar(@RequestBody CursoDTO curso) {
        cursoService.adicionar(curso);
    }

    @GetMapping
    public List<CursoDTO> listarCursos() {
        return cursoService.listarCursos();
    }
}
