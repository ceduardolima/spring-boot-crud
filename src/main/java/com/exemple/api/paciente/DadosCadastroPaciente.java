package com.exemple.api.paciente;

import com.exemple.api.address.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DadosCadastroPaciente(
        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank
        String telefone,
        @NotNull
        @Valid
        DadosEndereco endereco
) {
}
