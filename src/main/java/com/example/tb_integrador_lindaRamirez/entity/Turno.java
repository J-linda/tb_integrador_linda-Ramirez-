package com.example.tb_integrador_lindaRamirez.entity;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table (name = "turnos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "turno_sequence")
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne //(fetch = FetchType.LAZY)
    //@JsonBackReference
    //@JsonManagedReference
    //@JsonIdentityInfo
    @JoinColumn(name = "odontologo_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "odontologo"})
    private Odontologo odontologo;

    @ManyToOne//(fetch = FetchType.LAZY) se comentaron estas lineas
    //@JsonBackReference
    //@JsonManagedReference
   //@JsonIdentityInfo
    @JoinColumn(name = "paciente_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","paciente"})  //descomentada 6:39
    private Paciente paciente;
    private LocalDate fecha;
    private LocalTime hora;

}




