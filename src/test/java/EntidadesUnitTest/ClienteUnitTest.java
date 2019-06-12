package EntidadesUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Entidades.Cliente;
import Excepciones.ClienteIncompletoExcepcion;
import Excepciones.ClienteMenorDeEdadExcepcion;

class ClienteUnitTest {

	@Test
	void instanciarCliente_TodosLosAtributosCorrectos_InstanciaCorrecta() throws ClienteIncompletoExcepcion, ClienteMenorDeEdadExcepcion {
		Cliente prueba = Cliente.factoryCliente("Paez, Daniel Marcelo", "37492933","San Juan 580","+543825416602",
				LocalDate.of(1994, 01, 14));
		Assertions.assertNotNull(prueba);
	}
	
	@Test
	void instanciarCliente_TodosLosAtributosYUnAtributoNulo_InstanciaIncorrecta() throws ClienteIncompletoExcepcion {
		Assertions.assertThrows(ClienteIncompletoExcepcion.class, ()->  Cliente.factoryCliente(null, "37492933","San Juan 580","+543825416602",
				LocalDate.of(1994, 01, 14)));
	}
	
	@Test
	void instanciarCliente_TodosLosAtributosCorrectosYMayorDeEdad_InstanciaCorrecta() throws ClienteIncompletoExcepcion, ClienteMenorDeEdadExcepcion {
		Cliente prueba = Cliente.factoryCliente("Paez, Daniel Marcelo", "37492933","San Juan 580","+543825416602",
				LocalDate.of(1994, 01, 14));
		Assertions.assertNotNull(prueba);
	}
	
	@Test
	void instanciarCliente_TodosLosAtributosCorrectosMenorDeEdad_InstanciaIncorrecta() throws ClienteIncompletoExcepcion, ClienteMenorDeEdadExcepcion {
		Assertions.assertThrows(ClienteMenorDeEdadExcepcion.class, ()-> Cliente.factoryCliente("Paez, Daniel Marcelo", "37492933","San Juan 580","+543825416602",
				LocalDate.of(2012, 01, 14)));
	}

}
