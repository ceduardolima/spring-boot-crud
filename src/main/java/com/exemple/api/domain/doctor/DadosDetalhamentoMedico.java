package com.exemple.api.domain.doctor;

import com.exemple.api.address.Endereco;

public record DadosDetalhamentoMedico(
        Long id,
        String nome,
        String email,
        String cmr,
        String telefone,
        Especialidade especialidade,
        Endereco endereco) {
    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }

}
