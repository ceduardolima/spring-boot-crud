package com.exemple.api.address;

import com.exemple.api.address.DadosEndereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.numero = endereco.numero();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.complemento = endereco.complemento();
    }

    public void atualizarInformacoes(DadosEndereco endereco) {
        if (endereco.logradouro() != null)
            this.logradouro = endereco.logradouro();
        if (endereco.numero() != null)
            this.numero = endereco.numero();
        if (endereco.bairro() != null)
            this.bairro = endereco.bairro();
        if (endereco.cep() != null)
            this.cep = endereco.cep();
        if (endereco.cidade() != null)
            this.cidade = endereco.cidade();
        if (endereco.uf() != null)
            this.uf = endereco.uf();
        if (endereco.complemento() != null)
            this.complemento = endereco.complemento();
    }
}
