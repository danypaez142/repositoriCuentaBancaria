package Entidades;

import java.time.LocalDate;
import java.time.Period;

import Excepciones.ClienteIncompletoExcepcion;
import Excepciones.ClienteMenorDeEdadExcepcion;

public class Cliente {
	private String nombre;
	private String documento;
	private String domicilio;
	private String telefono;
	private LocalDate fechaNacimiento; 

	private Cliente(String nombre, String documento, String domicilio, String telefono, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.documento = documento;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
	}

	public static Cliente factoryCliente(String nombre, String documento, String domicilio, String telefono, LocalDate fechaNacimiento) throws ClienteIncompletoExcepcion, ClienteMenorDeEdadExcepcion {
		if(nombre == null || documento == null || domicilio == null || domicilio == null || telefono == null || fechaNacimiento == null) {
			throw new ClienteIncompletoExcepcion();
		}else if(Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18){			
			return new Cliente(nombre, documento, domicilio, telefono, fechaNacimiento);
		}else {
			throw new ClienteMenorDeEdadExcepcion();
		}
	}

}
