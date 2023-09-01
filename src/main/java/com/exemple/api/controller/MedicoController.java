package com.exemple.api.controller;

import com.exemple.api.doctor.DadosCadastroMedico;
import com.exemple.api.doctor.Medico;
import com.exemple.api.doctor.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico doctorRegisterData) {
        repository.save(new Medico(doctorRegisterData));
    }
}
