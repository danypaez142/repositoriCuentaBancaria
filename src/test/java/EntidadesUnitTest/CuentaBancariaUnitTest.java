package EntidadesUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import Entidades.Cliente;
import Entidades.CuentaBancaria;
import Excepciones.ClienteIncompletoExcepcion;
import Excepciones.ClienteMenorDeEdadExcepcion;
import Excepciones.CuentaBancariaIncompletaExcepcion;
import Interfaces.IFechaDelSistema;
import Interfaces.INumeroDeCuenta;
import Mockito.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CuentaBancariaUnitTest {
	@Mock
	IFechaDelSistema fechaDelSistemaParaEdad;
	@Mock
	INumeroDeCuenta numeroDeCuenta;
	@Mock
	IFechaDelSistema fechaDelSistemaParaCuentas;

	@Test
	void instanciarCuentaBancaria_TodosLosAtributosCorrectos_InstanciaCorrecta() throws ClienteIncompletoExcepcion, ClienteMenorDeEdadExcepcion, CuentaBancariaIncompletaExcepcion {
		Mockito.when(fechaDelSistemaParaEdad.getFechaSistema()).thenReturn(LocalDate.of(2019, 1, 1));
		Mockito.when(fechaDelSistemaParaCuentas.getFechaSistema()).thenReturn(LocalDate.now());
		Mockito.when(numeroDeCuenta.getSiguienteNumeroDeCuenta()).thenReturn(1);
		Cliente propietario = Cliente.factoryCliente("Paez, Daniel Marcelo", "37492933","San Juan 580","+543825416602",
				LocalDate.of(1994, 01, 14), fechaDelSistemaParaEdad);
		CuentaBancaria prueba = CuentaBancaria.factoryCuentaBancaria(numeroDeCuenta,propietario,fechaDelSistemaParaCuentas);
		Assertions.assertNotNull(prueba);
	}
	
	@Test
	void instanciarCuentaBancaria_TodosLosAtributosYUnAtributoNulo_InstanciaIncorrecta() throws ClienteIncompletoExcepcion, ClienteMenorDeEdadExcepcion, CuentaBancariaIncompletaExcepcion{
		Mockito.when(fechaDelSistemaParaEdad.getFechaSistema()).thenReturn(LocalDate.of(2019, 1, 1));
		Mockito.when(numeroDeCuenta.getSiguienteNumeroDeCuenta()).thenReturn(1);
		Cliente propietario = Cliente.factoryCliente("Paez, Daniel Marcelo", "37492933","San Juan 580","+543825416602",
				LocalDate.of(1994, 01, 14), fechaDelSistemaParaEdad);
		Assertions.assertThrows(CuentaBancariaIncompletaExcepcion.class, () -> CuentaBancaria.factoryCuentaBancaria(numeroDeCuenta, propietario, null));
	}

}
