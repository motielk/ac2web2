package com.example.agenda.services;

import com.example.agenda.dtos.ProfessorDTO;
import com.example.agenda.models.Professor;
import com.example.agenda.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public void adicionar(ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        professor.setNome(professorDTO.nome());
        professor.setCpf(professorDTO.cpf());
        professor.setRg(professorDTO.rg());
        professor.setEndereco(professorDTO.endereco());
        professor.setCelular(professorDTO.celular());

        professorRepository.save(professor);
    }

    @Override
    public List<ProfessorDTO> listarProfessores() {
        return professorRepository.findAll().stream()
                .map(professor -> {
                    List<Integer> cursos = professor.getCursos().stream()
                            .map(curso -> curso.getId())
                            .collect(Collectors.toList());

                    return new ProfessorDTO(
                            professor.getNome(),
                            professor.getCpf(),
                            professor.getRg(),
                            professor.getEndereco(),
                            professor.getCelular(),
                            cursos
                    );
                })
                .collect(Collectors.toList());
    }
}
