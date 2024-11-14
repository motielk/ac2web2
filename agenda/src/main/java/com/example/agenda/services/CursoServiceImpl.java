package com.example.agenda.services;

import com.example.agenda.dtos.CursoDTO;
import com.example.agenda.models.Curso;
import com.example.agenda.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void adicionar(CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setNome(cursoDTO.nome());
        curso.setDescricao(cursoDTO.descricao());
        curso.setCargaHoraria(cursoDTO.cargaHoraria());
        curso.setObjetivos(cursoDTO.objetivos());
        curso.setEmenda(cursoDTO.emenda());

        cursoRepository.save(curso);
    }

    @Override
    public List<CursoDTO> listarCursos() {
        return cursoRepository.findAll().stream()
                .map(curso -> new CursoDTO(
                        curso.getNome(),
                        curso.getDescricao(),
                        curso.getCargaHoraria(),
                        curso.getObjetivos(),
                        curso.getEmenda()))
                .collect(Collectors.toList());
    }
}
