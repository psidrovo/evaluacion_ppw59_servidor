package ec.edu.ups.ppw.ppw59.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.paul_idrovo_servidor.dao.AutomovilDAO;
import ec.edu.ups.paul_idrovo_servidor.model.Automovil;

@Stateless
public class GestionAutomoviles {
	@Inject
	private AutomovilDAO daoAutomovil;
	
	
	public void guardarAutomovil(Automovil auto) {
		Automovil a = daoAutomovil.read(auto.getPlaca());
		if(a==null) {
			daoAutomovil.insert(auto);
		}else {
			daoAutomovil.update(auto);
		}
		
	}
	
	public List<Automovil> getAutomoviles(){
		return daoAutomovil.getList();
	}
	
	public List<Automovil> getAutomovilesPlaca(String Filtro){
		Filtro = "%" + Filtro + "%";
		return daoAutomovil.getListNombre(Filtro);
	}
	
	public Automovil getAutomovil(String placa) {
		Automovil a = daoAutomovil.read(placa);
		return a;
	}
}
