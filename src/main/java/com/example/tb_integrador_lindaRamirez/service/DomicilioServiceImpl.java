package com.example.tb_integrador_lindaRamirez.service;
import com.example.tb_integrador_lindaRamirez.controller.DTO.DomicilioDTO;
import com.example.tb_integrador_lindaRamirez.entity.Domicilio;
import com.example.tb_integrador_lindaRamirez.repository.IDomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioServiceImpl implements DomicilioService {

    private final IDomicilioRepository domicilioRepository;
    @Autowired
    private final ObjectMapper mapper;

    public DomicilioServiceImpl(IDomicilioRepository domicilioRepository, ObjectMapper mapper) {
        this.domicilioRepository = domicilioRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Set<DomicilioDTO> obtenerTodos() {
        List<Domicilio> domicilios = domicilioRepository.findAll();
        Set<DomicilioDTO> domicilioDTOS = new HashSet<>();
        for (Domicilio domicilio: domicilios){
            DomicilioDTO domicilioDTO = new DomicilioDTO();
            domicilioDTO.setId(domicilio.getId());
            domicilioDTO.setCalle(domicilio.getCalle());
            domicilioDTO.setNumero(domicilio.getNumero());
            domicilioDTO.setLocalidad(domicilio.getLocalidad());
            domicilioDTO.setProvincia(domicilio.getProvincia());
            domicilioDTOS.add(domicilioDTO);
        }
        return domicilioDTOS;
    }

    @Override
    @Transactional(readOnly = true)
    public DomicilioDTO obtener(Long id) throws Exception {
        //DomicilioDTO domicilioDTO = null;
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        if(domicilio.isPresent()){
            return mapper.convertValue(domicilio, DomicilioDTO.class);
        }else {
            throw new Exception("Domicilio no se ha encontrado en la base de datos");
        }
    }
    //public Domicilio obtener(Long id) {
        //return domicilioRepository.getById(id);
    //}

    @Override
    @Transactional
    public DomicilioDTO agregar(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
        return new DomicilioDTO(domicilio.getId(), domicilio.getCalle(),domicilio.getNumero(),domicilio.getLocalidad(),domicilio.getProvincia());
    }

    @Override
    public DomicilioDTO modificar(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
        return new DomicilioDTO(domicilio.getId(), domicilio.getCalle(),domicilio.getNumero(),domicilio.getLocalidad(),domicilio.getProvincia());
    }

    @Override
    public void eliminar(Long id) {
    domicilioRepository.deleteById(id);
    }
}
