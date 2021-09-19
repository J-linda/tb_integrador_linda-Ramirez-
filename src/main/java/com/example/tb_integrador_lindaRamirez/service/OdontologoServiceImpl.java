package com.example.tb_integrador_lindaRamirez.service;
import com.example.tb_integrador_lindaRamirez.entity.Odontologo;
import com.example.tb_integrador_lindaRamirez.repository.IOdontologoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OdontologoServiceImpl implements OdontologoService{

    private final IOdontologoRepository odontologoRepository;  //  constante

    public OdontologoServiceImpl(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository; //inyeccion de dependiencias: autowired - la otra por medio del constructor como parametro
    }

    // METODOS
    @Override
    @Transactional(readOnly = true)
    public List<Odontologo> obtenerTodos() {
        return odontologoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Odontologo obtener(Long id) {
        return odontologoRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Odontologo agregar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }
    @Override
    public Odontologo modificar(Odontologo odontologo, Long id){
        Odontologo odontologo1 = odontologoRepository.findById(id).orElseThrow(() -> new RuntimeException("Odontologo no encontrado"));
        odontologo1.setNombre(odontologo.getNombre());
        odontologo1.setApellido(odontologo1.getApellido());
        odontologo1.setMatricula(odontologo1.getMatricula());
        return odontologoRepository.save(odontologo1);
    }

}
