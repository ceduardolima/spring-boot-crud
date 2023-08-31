package com.exemple.api.doctor;

import com.exemple.api.address.Address;

public record DadosCadastroMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        Address endereco
) {
}
