package com.example.tb_integrador_lindaRamirez.service;
import com.example.tb_integrador_lindaRamirez.controller.DTO.PacienteDTO;
import java.util.Set;

public interface PacienteService {

    Set<PacienteDTO> obtenerTodos();
    PacienteDTO obtener(Long id);
    PacienteDTO agregar(PacienteDTO pacienteDTO);
    PacienteDTO modificar(PacienteDTO pacienteDTO, Long id);
    void eliminar(Long id);
}
