package com.exemple.api.doctor;

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
