package Entidades;

import java.time.LocalDate;

import Excepciones.CuentaBancariaIncompletaExcepcion;
import Interfaces.IFechaDelSistema;
import Interfaces.INumeroDeCuenta;

public class CuentaBancaria {
	private Integer numeroCuentaBancaria;
	private Cliente propietario;
	private LocalDate fechaDeCreacion;
	
	private CuentaBancaria(Integer numeroCuentaBancaria, Cliente propietario, LocalDate fechaDeCreacion) {
		this.numeroCuentaBancaria = numeroCuentaBancaria;
		this.propietario = propietario;
		this.fechaDeCreacion = fechaDeCreacion;
	}



	public static CuentaBancaria factoryCuentaBancaria(INumeroDeCuenta numeroDeCuenta, Cliente propietario, IFechaDelSistema fechaDeCreacion) throws CuentaBancariaIncompletaExcepcion {
		if(numeroDeCuenta == null || propietario == null || fechaDeCreacion == null) {
			throw new CuentaBancariaIncompletaExcepcion();
		}else {
			return new CuentaBancaria(numeroDeCuenta.getSiguienteNumeroDeCuenta(), propietario, fechaDeCreacion.getFechaSistema());
		}
	}

}
