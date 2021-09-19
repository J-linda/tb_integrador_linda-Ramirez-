package com.example.tb_integrador_lindaRamirez.controller;
import com.example.tb_integrador_lindaRamirez.entity.Domicilio;
import com.example.tb_integrador_lindaRamirez.service.DomicilioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("domicilios")
public class DomicilioController {

    private final DomicilioService domicilioService;

    public DomicilioController(DomicilioService domicilioService) {
        this.domicilioService = domicilioService;
    }
    @GetMapping
    public List<Domicilio> obtenerTodos(){
       return domicilioService.obtenerTodos();
    }
    @GetMapping(path = "{id}")
    public Domicilio obtener(@PathVariable Long id){
        return domicilioService.obtener(id);
    }
    //public Domicilio obtener(@PathVariable("id") Long id) {
        //return domicilioService.obtener(id);
   // }

    @PostMapping
    public ResponseEntity<Domicilio>agregar(@RequestBody Domicilio domicilio) {
        domicilioService.agregar(domicilio);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping(path = "{id}")// debe tener el path???
    public ResponseEntity<Domicilio>modificar(@RequestBody Domicilio domicilio, @PathVariable Long id){
        domicilioService.modificar(domicilio,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(path = "{id}")
    public String eliminar(@PathVariable Long id){
        domicilioService.eliminar(id);
        return "El domicilio fue eliminado";
    }

}
