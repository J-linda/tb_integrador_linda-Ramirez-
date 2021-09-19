package com.example.tb_integrador_lindaRamirez.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/*-----------ENTITY ES UNA CLASE QUE SE VA A VOLVER ENTIDAD Y SU FUTURA TABLA Y EL NAME ES EL NOMBRE DE LA TABLA EN SQL-------*/
@Entity
@Table(name="pacientes")
public class Paciente implements Serializable {


    /*------------------GENERAMOS ID AUTOMATICAMENTE-----------------*/
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long id;

    @Id
    //@SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*---------------------------ATRIBUTOS O PROPIEDADES DE LA ENTIDAD------------*/
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaAlta;


    /*-------------GENERAMOS LA RELACION EN ESE CASO UNO A UNO-----------------*/
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Domicilio domicilio;

    /*---------------SIEMPRE DEBE IR UN CONSTRUCTOR VACIO POR REQUERIMIENTO DE JPA--------*/
    public Paciente() {
    }

/*---------------EN EL CONSTRUCTOR NUNCA DEBE IR ID POR QUE SE GENERA AUTOMATICAMENTE--------*/
    public Paciente(String nombre, String apellido, String dni, LocalDate fechaAlta, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
        this.domicilio = domicilio;
    }

    /*-----------------------GETTERS Y SETTERS DE TODOS , EL ID SOLO DEBE TENER EN GET POR BUENAS PRACTICAS---------*/
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}