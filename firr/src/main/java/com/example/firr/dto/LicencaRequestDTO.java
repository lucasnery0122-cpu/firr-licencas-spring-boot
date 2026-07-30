package com.example.firr.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class LicencaRequestDTO {

    @NotBlank(message = "O nome da licença é obrigatório.")
    private String nome;

    @NotBlank(message = "O órgão emissor é obrigatório.")
    private String orgaoEmissor;

    @NotNull(message = "A data de validade é obrigatória.")
    private LocalDate dataValidade;

    @NotBlank(message = "O status da licença é obrigatório (ex: ATIVA, VENCIDA).")
    private String status;
}