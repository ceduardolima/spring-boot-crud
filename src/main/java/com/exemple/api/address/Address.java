package com.exemple.api.address;

public record Address(
        String logradouro,
        String numero,
        String bairro,
        String cep,
        String cidade,
        String uf,
        String complemento
) {

}
