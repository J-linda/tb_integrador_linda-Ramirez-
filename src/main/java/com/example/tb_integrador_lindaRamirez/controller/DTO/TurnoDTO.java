package com.example.tb_integrador_lindaRamirez.controller.DTO;
import com.example.tb_integrador_lindaRamirez.entity.Odontologo;
import com.example.tb_integrador_lindaRamirez.entity.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurnoDTO implements Serializable {

        private Long id;
        private Odontologo odontologo;
        private Paciente paciente;
        private LocalDate fecha;
        private LocalTime hora;

}

