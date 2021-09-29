package com.example.tb_integrador_lindaRamirez.service;
import com.example.tb_integrador_lindaRamirez.controller.DTO.OdontologoDTO;

import java.util.Set;


public interface OdontologoService {

    Set<OdontologoDTO> obtenerTodos();
    OdontologoDTO obtener (Long id);
    OdontologoDTO agregar (OdontologoDTO odontologoDTO);
    OdontologoDTO modificar (OdontologoDTO odontologoDTO, Long id);

}
