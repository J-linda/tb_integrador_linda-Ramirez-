package com.example.tb_integrador_lindaRamirez.controller;
import com.example.tb_integrador_lindaRamirez.controller.DTO.OdontologoDTO;
import com.example.tb_integrador_lindaRamirez.service.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("odontologos")
public class OdontologoController {

    private final OdontologoService odontologoService;

    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }
    //metodos

    @GetMapping
    public Set<OdontologoDTO> obtenerTodos() {
        return odontologoService.obtenerTodos();
    }

    @GetMapping(path = "{id}")
    public OdontologoDTO obtener(@PathVariable Long id) throws Exception {
        return odontologoService.obtener(id);
    }

    //@GetMapping("{apellido}")
    //@RequestMapping(value = "apellido/{apellido}", method = RequestMethod.GET)
    //public Set<OdontologoDTO>buscarPorApellido(@PathVariable String apellido) {
       // return odontologoService.getOdontologoWithApellidoLike(apellido);
    //}

    @GetMapping("apellido/{apellido}")
    public Set<OdontologoDTO> findByApellidoContaining(@PathVariable String apellido){
        return odontologoService.findByApellidoContaining(apellido);
    }

    @PostMapping //verbo de HTTP
    public ResponseEntity<OdontologoDTO> agregar(@RequestBody OdontologoDTO odontologo) {
        odontologoService.agregar(odontologo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping//(path = "{id}")
    public ResponseEntity<OdontologoDTO> modificar(@RequestBody OdontologoDTO odontologo) {
        odontologoService.modificar(odontologo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}