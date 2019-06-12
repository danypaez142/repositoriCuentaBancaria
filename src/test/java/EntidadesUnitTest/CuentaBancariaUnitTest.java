package EntidadesUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Entidades.Cliente;
import Excepciones.ClienteIncompletoExcepcion;
import Excepciones.ClienteMenorDeEdadExcepcion;

class CuentaBancariaUnitTest {

	@Test
	void instanciarCuentaBancaria_TodosLosAtributosCorrectos_InstanciaCorrecta() throws ClienteIncompletoExcepcion, ClienteMenorDeEdadExcepcion {
		Cliente propietario = Cliente.factoryCliente("Paez, Daniel Marcelo", "37492933","San Juan 580","+543825416602",
				LocalDate.of(1994, 01, 14));
		CuentaBancaria prueba = CuentaBancaria.factoryCuentaBancaria(1,propietario,LocalDate.now());
		Assertions.assertNotNull(prueba);
	}

}
