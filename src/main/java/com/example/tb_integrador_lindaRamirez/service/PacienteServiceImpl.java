package com.example.tb_integrador_lindaRamirez.service;
import com.example.tb_integrador_lindaRamirez.controller.DTO.PacienteDTO;
import com.example.tb_integrador_lindaRamirez.entity.Paciente;
import com.example.tb_integrador_lindaRamirez.repository.IDomicilioRepository;
import com.example.tb_integrador_lindaRamirez.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteServiceImpl implements PacienteService {


    private final IPacienteRepository pacienteRepository;
    private final IDomicilioRepository domicilioRepository;
    @Autowired
    private final ObjectMapper mapper;

    public PacienteServiceImpl(IPacienteRepository pacienteRepository, IDomicilioRepository domicilioRepository, ObjectMapper mapper) {
        this.pacienteRepository = pacienteRepository;
        this.domicilioRepository = domicilioRepository;
        this.mapper = mapper;
    }

    //METODOS
    @Override
    @Transactional(readOnly = true)
    public Set<PacienteDTO> obtenerTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacienteDTOS = new HashSet<>();
        for (Paciente paciente: pacientes){
            PacienteDTO pacienteDTO = new PacienteDTO();
            pacienteDTO.setId(paciente.getId());
            pacienteDTO.setNombre(paciente.getNombre());
            pacienteDTO.setApellido(paciente.getApellido());
            pacienteDTO.setDni(paciente.getDni());
            pacienteDTO.setFechaAlta(paciente.getFechaAlta());
            pacienteDTO.setDomicilio(paciente.getDomicilio());

            pacienteDTOS.add(pacienteDTO);
        }
        return  pacienteDTOS;
    }

    @Override
    @Transactional(readOnly = true)
    public PacienteDTO obtener(Long id) throws Exception {
        //PacienteDTO pacienteDTO = null;
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isPresent()){
            return mapper.convertValue(paciente, PacienteDTO.class);
        }else {
            throw new Exception("Paciente no se ha encontrado en la base de datos");
        }
    }

    @Override
    @Transactional
    public PacienteDTO agregar(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        paciente.setDomicilio(pacienteDTO.getDomicilio());
        pacienteRepository.save(paciente);
        domicilioRepository.save(pacienteDTO.getDomicilio());
        System.out.println(paciente);
        return new PacienteDTO(paciente.getId(), paciente.getNombre(),paciente.getApellido(), paciente.getDni(), paciente.getFechaAlta(), paciente.getDomicilio());
    }

    @Override
    public PacienteDTO modificar(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
        return new PacienteDTO(paciente.getId(), paciente.getNombre(),paciente.getApellido(), paciente.getDni(), paciente.getFechaAlta(), pacienteDTO.getDomicilio());
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }
}

