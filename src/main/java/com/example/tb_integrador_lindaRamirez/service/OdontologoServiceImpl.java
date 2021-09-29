package com.example.tb_integrador_lindaRamirez.service;
import com.example.tb_integrador_lindaRamirez.controller.DTO.OdontologoDTO;
import com.example.tb_integrador_lindaRamirez.entity.Odontologo;
import com.example.tb_integrador_lindaRamirez.repository.IDomicilioRepository;
import com.example.tb_integrador_lindaRamirez.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoServiceImpl implements OdontologoService{

    private final IOdontologoRepository odontologoRepository;  //  constante
    @Autowired
    private ObjectMapper mapper;

    public OdontologoServiceImpl(IOdontologoRepository odontologoRepository, ObjectMapper mapper, IDomicilioRepository domicilioRepository, ObjectMapper mapper1) {
        this.odontologoRepository = odontologoRepository;
        this.mapper = mapper;

    }

    // METODOS
    @Override
    @Transactional(readOnly = true)
    public Set<OdontologoDTO> obtenerTodos() {
        List<Odontologo>odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO>odontologoDTOS = new HashSet<>();
        for (Odontologo odontologo: odontologos){
            OdontologoDTO odontologoDTO = new OdontologoDTO();
            odontologoDTO.setId(odontologo.getId());
            odontologoDTO.setNombre(odontologo.getNombre());
            odontologoDTO.setApellido(odontologo.getApellido());
            odontologoDTO.setMatricula(odontologo.getMatricula());
            odontologoDTOS.add(odontologoDTO);
        }
        return odontologoDTOS;
    }

    @Override
    @Transactional(readOnly = true)
    public OdontologoDTO obtener(Long id) {
        OdontologoDTO odontologoDTO = null;
        Optional<Odontologo>odontologo = odontologoRepository.findById(id);
        if (odontologo.isPresent()) {
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    @Override
    @Transactional
    public OdontologoDTO agregar(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
        return new OdontologoDTO(odontologo.getId(), odontologo.getNombre(), odontologo.getApellido(),odontologo.getMatricula());
    }
    @Override
    public OdontologoDTO modificar(OdontologoDTO odontologoDTO, Long id){
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
        return new OdontologoDTO(odontologoDTO.getId(), odontologo.getNombre(), odontologo.getApellido(),odontologo.getMatricula());
    }

}


