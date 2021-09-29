package com.example.tb_integrador_lindaRamirez.controller;
import com.example.tb_integrador_lindaRamirez.controller.DTO.TurnoDTO;
import com.example.tb_integrador_lindaRamirez.service.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("turnos")
public class TurnoController {

        private final TurnoService turnoService;

        public TurnoController(TurnoService turnoService) {
            this.turnoService = turnoService;
        }

        //METODOS
        @GetMapping
        public Set<TurnoDTO> obtenerTodos(){
            return turnoService.obtenerTodos();
        }
        @GetMapping (path= "{id}")
        public TurnoDTO obtener(@PathVariable Long id) throws Exception {
            return turnoService.obtener(id);
       }

        @PostMapping
        public ResponseEntity<TurnoDTO> agregar(@RequestBody TurnoDTO turno){
            turnoService.agregar(turno);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        @PutMapping//(path = "{id}")
        public ResponseEntity<TurnoDTO>modificar(@RequestBody TurnoDTO turno){
            turnoService.modificar(turno);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        @DeleteMapping(path = "{id}")
        public String eliminar(@PathVariable Long id){
            turnoService.eliminar(id);
            return "Se elimino el turno";
        }
    }

