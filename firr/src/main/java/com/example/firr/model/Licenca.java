package com.example.firr.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "T_FIRR_LICENCAS")
@Data
public class Licenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "ORGAO_EMISSOR") // <-- Mapeado explicitamente para o padrão do banco
    private String orgaoEmissor;

    @Column(name = "DATA_VALIDADE") // <-- Mapeado explicitamente para o padrão do banco
    private LocalDate dataValidade;

    @Column(name = "STATUS")
    private String status;
}