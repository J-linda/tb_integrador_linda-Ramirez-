package com.example.tb_integrador_lindaRamirez.service;
import com.example.tb_integrador_lindaRamirez.controller.DTO.OdontologoDTO;

import java.util.Set;


public interface OdontologoService {

    Set<OdontologoDTO> obtenerTodos();
    Set<OdontologoDTO> getOdontologoWithApellidoLike(String apellido);
    OdontologoDTO obtener (Long id) throws Exception;
    OdontologoDTO agregar (OdontologoDTO odontologoDTO);
    OdontologoDTO modificar (OdontologoDTO odontologoDTO);
}
