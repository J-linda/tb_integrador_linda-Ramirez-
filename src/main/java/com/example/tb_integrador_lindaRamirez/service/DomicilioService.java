package com.example.tb_integrador_lindaRamirez.service;
import com.example.tb_integrador_lindaRamirez.controller.DTO.DomicilioDTO;
import java.util.Set;

public interface DomicilioService {

    Set<DomicilioDTO> obtenerTodos();
    DomicilioDTO obtener(Long id);
    DomicilioDTO agregar (DomicilioDTO domicilioDTO);
    DomicilioDTO modificar (DomicilioDTO domicilioDTO, Long id);
    void eliminar (Long id);
}
