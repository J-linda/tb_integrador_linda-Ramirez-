package com.example.tb_integrador_lindaRamirez;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TbIntegradorLindaRamirezApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(TbIntegradorLindaRamirezApplication.class, args);

	}


}
