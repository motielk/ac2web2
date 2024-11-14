package com.example.agenda.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(length = 200, nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer cargaHoraria;

    @Column(length = 200, nullable = false)
    private String objetivos;

    @Column(length = 200, nullable = false)
    private String emenda;

    @ManyToMany
    @JoinTable(
            name = "curso_professor",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    private List<Professor> professores;

    @Override
    public String toString() {
        return "Curso{id=" + id + ", nome='" + nome + "'}";
    }
}
