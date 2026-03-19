package servicios;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import interfaces.InterfazContactoSim;
import modelo.DatosSimulation;
import modelo.DatosSolicitud;
import modelo.Entidad;

//@Autowire
public class ContactoSim implements InterfazContactoSim {

	private List<Entidad> entidades;
    private Map<Integer, DatosSolicitud> solicitudes;
    private SecureRandom random;
 
    
	@Override
	public int solicitarSimulation(DatosSolicitud sol) {
		int token = random.nextInt(1000000) + 1;
		solicitudes.put(token, sol);
		return token;
	}

	@Override
	public DatosSimulation descargarDatos(int ticket) {
		return new DatosSimulation();
	}

	@Override
	public List<Entidad> getEntities() {
		return entidades;
	}

	@Override
	public boolean isValidEntityId(int ticket) {
		return solicitudes.containsKey(ticket);
	}

}
