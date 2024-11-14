package com.example.agenda.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AgendaDTO(LocalDate data, LocalDateTime horario, String cidade, String uf, String cep, String resumo) {
    
}
