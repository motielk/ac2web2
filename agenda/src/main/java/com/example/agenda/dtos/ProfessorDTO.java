package com.example.agenda.dtos;

import java.util.List;

public record ProfessorDTO(String nome, String cpf, String rg, String endereco, String celular, List<Integer> cursosIds) {

}
