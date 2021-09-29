package com.example.tb_integrador_lindaRamirez.controller;
import com.example.tb_integrador_lindaRamirez.controller.DTO.PacienteDTO;
import com.example.tb_integrador_lindaRamirez.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    //METODOS
    @GetMapping
    public Set<PacienteDTO> obtenerTodos(){
        return pacienteService.obtenerTodos();
    }
    @GetMapping (path= "{id}")
    public PacienteDTO obtener(@PathVariable Long id){
        return pacienteService.obtener(id);
    }

    @PostMapping
    public ResponseEntity<PacienteDTO>agregar(@RequestBody PacienteDTO paciente){
        pacienteService.agregar(paciente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping(path = "{id}")
    public ResponseEntity<PacienteDTO>modificar(@RequestBody PacienteDTO paciente, @PathVariable Long id){
        pacienteService.modificar(paciente,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(path = "{id}")
    public String eliminar(@PathVariable Long id){
        pacienteService.eliminar(id);
        return "Se elimino el paciente";
    }
}



