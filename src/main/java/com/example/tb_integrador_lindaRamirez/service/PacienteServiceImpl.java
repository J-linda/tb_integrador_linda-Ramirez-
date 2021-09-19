package com.example.tb_integrador_lindaRamirez.service;
import com.example.tb_integrador_lindaRamirez.entity.Paciente;
import com.example.tb_integrador_lindaRamirez.repository.IPacienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final IPacienteRepository pacienteRepository;

    public PacienteServiceImpl(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    //METODOS
    @Override
    @Transactional(readOnly = true)
    public List<Paciente> obtenerTodos() {
        return pacienteRepository.findAll();
    }
    @Override
    @Transactional(readOnly = true)
    public Paciente obtener(Long id) {
        return pacienteRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Paciente agregar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente modificar(Paciente paciente, Long id) {
        Paciente paciente1 = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        paciente1.setNombre(paciente.getNombre());
        paciente1.setApellido(paciente.getApellido());
        paciente1.setDni(paciente.getDni());
        paciente1.setDomicilio(paciente.getDomicilio());
        paciente1.setFechaAlta(paciente.getFechaAlta());
        return pacienteRepository.save(paciente1);
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }
}