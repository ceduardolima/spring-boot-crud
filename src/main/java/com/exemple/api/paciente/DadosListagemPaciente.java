package com.exemple.api.paciente;

public record DadosListagemPaciente(
        Long id,
        String name,
        String telefone,
        String cpf
) {
    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getTelefone(), paciente.getCpf());
    }
}
