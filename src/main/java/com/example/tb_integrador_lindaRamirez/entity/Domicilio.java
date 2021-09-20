package com.example.tb_integrador_lindaRamirez.entity;
import javax.persistence.*;

@Entity
@Table(name="domicilios")
public class Domicilio {

    @Id
    // @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    // @OneToOne (mappedBy = "domicilio") //para eliminar por ejemplo un paciente entonces su domicilio tambien
    // @JoinColumn(name = "pacientes_id")
    // private Paciente paciente;

    public Domicilio() {
    }

    public Domicilio(String calle, String numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Long getId() {
        return id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


}
