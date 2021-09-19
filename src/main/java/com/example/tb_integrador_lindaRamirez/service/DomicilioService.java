package com.example.tb_integrador_lindaRamirez.service;
import com.example.tb_integrador_lindaRamirez.entity.Domicilio;

import java.util.List;

public interface DomicilioService {

    List<Domicilio>obtenerTodos();
    Domicilio obtener(Long id);
    Domicilio agregar (Domicilio domicilio);
    Domicilio modificar (Domicilio domicilio, Long id);
    void eliminar (Long id);


}
