package com.example.tb_integrador_lindaRamirez.controller;
import com.example.tb_integrador_lindaRamirez.entity.Odontologo;
import com.example.tb_integrador_lindaRamirez.service.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("odontologos")
public class OdontologoController {

   private final OdontologoService odontologoService;

    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }
    //metodos

    @GetMapping
    public List<Odontologo>obtenerTodos(){
        return odontologoService.obtenerTodos();
    }
    @GetMapping(path= "{id}")
    public Odontologo obtener(@PathVariable Long id){
        return odontologoService.obtener(id);
    }

    @PostMapping //verbo de HTTP
    public ResponseEntity<Odontologo>agregar(@RequestBody Odontologo odontologo){
        odontologoService.agregar(odontologo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping(path="{id}")
    public ResponseEntity<Odontologo>modificar(@RequestBody Odontologo odontologo, @PathVariable Long id){
        odontologoService.modificar(odontologo,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
