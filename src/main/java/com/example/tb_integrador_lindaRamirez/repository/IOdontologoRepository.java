package com.example.tb_integrador_lindaRamirez.repository;
import com.example.tb_integrador_lindaRamirez.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IOdontologoRepository extends JpaRepository <Odontologo, Long> {

    //@Query("from Odontologo s where s.apellido like %:apellido%")
    //@Query("select od from Odontologo od where od.apellido like '%:apellido%'")
    //Set<Odontologo> getOdontologoByApellidoLike(@Param("apellido") String apellido);
    Set<Odontologo>findByApellidoContaining(String apellido);
}
