package com.example.tb_integrador_lindaRamirez;

import com.example.tb_integrador_lindaRamirez.controller.DTO.OdontologoDTO;
import com.example.tb_integrador_lindaRamirez.service.OdontologoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    OdontologoService odontologoService;

    @Test
    public void testgetOdontologotWithApellidoLike() {
        OdontologoDTO odontologo = new OdontologoDTO();
        odontologo.setNombre("Linda");
        odontologo.setApellido("pruebaTest");

        odontologoService.agregar(odontologo);
        Set<OdontologoDTO> odontologos = odontologoService.findByApellidoContaining("prueba");
        boolean resultado = odontologos.size() > 0;

        assertTrue(resultado);
    }
}


