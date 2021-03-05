package br.dev.rvz.gerenciadorhopital.services;

import br.dev.rvz.gerenciadorhopital.models.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {
    @Autowired
    private PacienteService pacienteService;

    List<Consulta> consultas = new ArrayList<>();


}
