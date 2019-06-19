package EntidadesUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import Entidades.Cliente;
import Excepciones.ClienteIncompletoExcepcion;
import Excepciones.ClienteMenorDeEdadExcepcion;
import Interfaces.IFechaDelSistema;
import Mockito.MockitoExtension;

@ExtendWith(MockitoExtension.class)

class ClienteUnitTest {
	@Mock
	IFechaDelSistema fechaDelSistema;

	@Test
	void instanciarCliente_TodosLosAtributosCorrectos_InstanciaCorrecta() throws ClienteIncompletoExcepcion, ClienteMenorDeEdadExcepcion {
		Mockito.when(fechaDelSistema.getFechaSistema()).thenReturn(LocalDate.of(2019, 1, 1));
		Cliente prueba = Cliente.factoryCliente("Paez, Daniel Marcelo", "37492933","San Juan 580","+543825416602",
				LocalDate.of(1994, 01, 14), fechaDelSistema);
		Assertions.assertNotNull(prueba);
	}
	
	@Test
	void instanciarCliente_TodosLosAtributosYUnAtributoNulo_InstanciaIncorrecta() throws ClienteIncompletoExcepcion {
		Mockito.when(fechaDelSistema.getFechaSistema()).thenReturn(LocalDate.of(2019, 1, 1));
		Assertions.assertThrows(ClienteIncompletoExcepcion.class, ()->  Cliente.factoryCliente(null, "37492933","San Juan 580","+543825416602",
				LocalDate.of(1994, 01, 14), fechaDelSistema));
	}
	
	@Test
	void instanciarCliente_TodosLosAtributosCorrectosYMayorDeEdad_InstanciaCorrecta() throws ClienteIncompletoExcepcion, ClienteMenorDeEdadExcepcion {
		Mockito.when(fechaDelSistema.getFechaSistema()).thenReturn(LocalDate.of(2019, 1, 1));
		Cliente prueba = Cliente.factoryCliente("Paez, Daniel Marcelo", "37492933","San Juan 580","+543825416602",
				LocalDate.of(1994, 01, 14), fechaDelSistema);
		Assertions.assertNotNull(prueba);
	}
	
	@Test
	void instanciarCliente_TodosLosAtributosCorrectosMenorDeEdad_InstanciaIncorrecta() throws ClienteIncompletoExcepcion, ClienteMenorDeEdadExcepcion {
		Mockito.when(fechaDelSistema.getFechaSistema()).thenReturn(LocalDate.of(2019, 1, 1));
		Assertions.assertThrows(ClienteMenorDeEdadExcepcion.class, ()-> Cliente.factoryCliente("Paez, Daniel Marcelo", "37492933","San Juan 580","+543825416602",
				LocalDate.of(2012, 01, 14), fechaDelSistema));
	}

}
