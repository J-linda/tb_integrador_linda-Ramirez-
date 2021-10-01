package com.example.tb_integrador_lindaRamirez.entity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="domicilios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Domicilio {

    @Id
    @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "domicilio_sequence")
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    // @OneToOne (mappedBy = "domicilio") //para eliminar por ejemplo un paciente entonces su domicilio tambien
    // @JoinColumn(name = "pacientes_id")
    // private Paciente paciente;
}