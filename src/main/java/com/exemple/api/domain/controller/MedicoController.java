package com.exemple.api.domain.controller;

import com.exemple.api.domain.doctor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico doctorRegisterData, UriComponentsBuilder uriComponentsBuilder) {
        /*
         * O método de cadastro precisa retornar o código 201. Esse código é representado pela classe estática
         * ResponseEntity.created() no SpringBoot. PAra retornarmos esse código, nós precisamos colocar a uri a qual
         * o objeto foi criado (nesse caso http://localhost:8080/medicos/{id}) no header, e retornar o objeto criado
         * no corpo da resposta.
         */
        var medico = new Medico(doctorRegisterData);
        repository.save(medico);
        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        /*
         * Para a listagem de dados, basta retornamos o código 200 com os dados no corpo.
         */
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        /*
         * Para atualizar os dados, basta retornamos o código 200 com o objeto atualizado no corpo.
         */
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }
}
