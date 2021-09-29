package com.example.tb_integrador_lindaRamirez.service;
import com.example.tb_integrador_lindaRamirez.controller.DTO.TurnoDTO;

import java.util.Collection;
import java.util.Set;

public interface TurnoService {

    Set<TurnoDTO>obtenerTodos();
    TurnoDTO obtener(Long id);
    TurnoDTO agregar(TurnoDTO turnoDTO);
    TurnoDTO modificar(TurnoDTO turnoDTO, Long id);
    void eliminar(Long id);

}
