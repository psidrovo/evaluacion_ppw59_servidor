package ec.edu.ups.ppw.ppw59.service;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.paul_idrovo_servidor.model.Automovil;
import ec.edu.ups.ppw.ppw59.business.GestionAutomoviles;


@Path("clientes")
public class AutomovilesServiceRest {

	@Inject
	private GestionAutomoviles facOn;
	
	@POST
	@Path("suma")
	public double suma(@QueryParam("a") double a,@QueryParam("b") double b) {
		return a+b;
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Respuesta crearAuto(Automovil automovil) {
		//instruciones de la funcionalidad
		Automovil aut = new Automovil();
		aut.setPlaca("ABC-0665");
		aut.setColor("BLANCO");
		aut.setMarca("FORD");
		aut.setAnio("2003");
		Respuesta res = new Respuesta();
		try {
			facOn.guardarAutomovil(automovil);
			res.setCodig(1);
			res.setMensaje("si ok");
			return res;
			
		} catch (Exception e) {
			// TODO: handle exception
			res.setCodig(99);
			res.setMensaje("");
			return res;
		}

	} 

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Automovil> getAutomoviles(){
		return facOn.getAutomoviles();
		
	}
	
}