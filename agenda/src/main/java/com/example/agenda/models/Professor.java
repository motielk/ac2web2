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
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(length = 200, nullable = false, unique = true)
    private String cpf;

    @Column(length = 200, nullable = false, unique = true)
    private String rg;

    @Column(length = 200, nullable = false)
    private String endereco;

    @Column(length = 200, nullable = false)
    private String celular;

    @ManyToMany(mappedBy = "professores")
    private List<Curso> cursos;

    @Override
    public String toString() {
        return "Professor{id=" + id + ", nome='" + nome + "'}";
    }
}
