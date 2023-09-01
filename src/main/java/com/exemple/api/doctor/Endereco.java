package com.exemple.api.doctor;

import com.exemple.api.address.Address;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    public String logradouro;
    public String numero;
    public String bairro;
    public String cep;
    public String cidade;
    public String uf;
    public String complemento;

    public Endereco(Address endereco) {
        this.logradouro = endereco.logradouro();
        this.numero = endereco.numero();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();;
        this.complemento = endereco.complemento();
    }
}
