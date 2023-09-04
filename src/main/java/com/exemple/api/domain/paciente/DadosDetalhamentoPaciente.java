package com.exemple.api.domain.paciente;

import com.exemple.api.address.Endereco;

public record DadosDetalhamentoPaciente(
        Long id,
        String nome,
        String cpf,
        String telefone,
        Endereco endereco

) {
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}
