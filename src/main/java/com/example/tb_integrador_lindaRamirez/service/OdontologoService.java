package com.example.tb_integrador_lindaRamirez.service;
import com.example.tb_integrador_lindaRamirez.entity.Odontologo;

import java.util.List;


public interface OdontologoService {

    List<Odontologo>obtenerTodos();
    Odontologo obtener (Long id);
    Odontologo agregar (Odontologo odontologo);
    Odontologo modificar (Odontologo odontologo, Long id);

}
