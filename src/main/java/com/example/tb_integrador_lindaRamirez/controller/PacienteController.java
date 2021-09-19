package com.example.tb_integrador_lindaRamirez.controller;
import com.example.tb_integrador_lindaRamirez.entity.Paciente;
import com.example.tb_integrador_lindaRamirez.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    //METODOS
    @GetMapping
    public List<Paciente>obtenerTodos(){
        return pacienteService.obtenerTodos();
    }
    @GetMapping (path= "{id}")
    public Paciente obtener(@PathVariable Long id){
        return pacienteService.obtener(id);
    }

    @PostMapping
    public ResponseEntity<Paciente>agregar(@RequestBody Paciente paciente){
        pacienteService.agregar(paciente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping(path = "{id}")
    public ResponseEntity<Paciente>modificar(@RequestBody Paciente paciente, @PathVariable Long id){
        pacienteService.modificar(paciente,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(path = "{id}")
    public String eliminar(@PathVariable Long id){
        pacienteService.eliminar(id);
        return "Se elimino el paciente";
    }
}
