package com.example.tb_integrador_lindaRamirez.service;
import com.example.tb_integrador_lindaRamirez.controller.DTO.TurnoDTO;
import com.example.tb_integrador_lindaRamirez.entity.Turno;
import com.example.tb_integrador_lindaRamirez.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TurnoServiceImpl implements TurnoService{

    private final ITurnoRepository turnoRepository;
    @Autowired
    private final ObjectMapper mapper;

    public TurnoServiceImpl(ITurnoRepository turnoRepository, ObjectMapper mapper) {
        this.turnoRepository = turnoRepository;
        this.mapper = mapper;
    }

    //METODOS
    @Override
   @Transactional(readOnly = true)
   public Set<TurnoDTO> obtenerTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnoDTOS = new HashSet<>();
        for (Turno turno: turnos){
            TurnoDTO turnoDTO = new TurnoDTO();
            turnoDTO.setId(turno.getId());
            turnoDTO.setOdontologo(turno.getOdontologo());
            turnoDTO.setPaciente(turno.getPaciente());
            turnoDTO.setFecha(turno.getFecha());
            turnoDTO.setHora(turno.getHora());
                turnoDTOS.add(turnoDTO);
        }
        return  turnoDTOS;
    }

    @Override
    @Transactional(readOnly = true)
    public TurnoDTO obtener(Long id) {
        TurnoDTO turnoDTO = null;
        Optional<Turno> turno = turnoRepository.findById(id);
            if(turno.isPresent()){
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }
        return turnoDTO;
    }

    @Override
    @Transactional
    public TurnoDTO agregar(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
        return new TurnoDTO(turno.getId(), turno.getOdontologo(),turno.getPaciente(), turno.getFecha(), turno.getHora());
    }

    @Override
    public TurnoDTO modificar(TurnoDTO turnoDTO, Long id) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
        return new TurnoDTO(turno.getId(), turno.getOdontologo(),turno.getPaciente(), turno.getFecha(), turno.getHora());
    }

    @Override
    public void eliminar(Long id) {
        turnoRepository.deleteById(id);
    }
}
