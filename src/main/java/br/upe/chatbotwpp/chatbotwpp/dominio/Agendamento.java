package br.upe.chatbotwpp.chatbotwpp.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dia;

    private String horaInicio;

    private String horaFim;

    private boolean status;
}
