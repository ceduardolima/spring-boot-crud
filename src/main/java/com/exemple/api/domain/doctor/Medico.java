package com.exemple.api.domain.doctor;

import com.exemple.api.address.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;
    private boolean ativo;

    public Medico(DadosCadastroMedico doctorRegisterData) {
        this.ativo = true;
        this.nome = doctorRegisterData.nome();
        this.email = doctorRegisterData.email();
        this.crm = doctorRegisterData.crm();
        this.telefone = doctorRegisterData.telefone();
        this.especialidade = doctorRegisterData.especialidade();
        this.endereco = new Endereco(doctorRegisterData.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if (dados.nome() != null)
            this.nome = dados.nome();
        if (dados.telefone() != null)
            this.telefone  = dados.telefone();
        if (dados.endereco() != null)
            this.endereco.atualizarInformacoes(dados.endereco());
    }

    public void excluir() {
        this.ativo = false;
    }
}