package com.example.tb_integrador_lindaRamirez.service;
import com.example.tb_integrador_lindaRamirez.entity.Paciente;
import java.util.List;

public interface PacienteService {

    List<Paciente>obtenerTodos();
    Paciente obtener(Long id);
    Paciente agregar(Paciente paciente);
    Paciente modificar(Paciente paciente, Long id);
    void eliminar(Long id);
}
