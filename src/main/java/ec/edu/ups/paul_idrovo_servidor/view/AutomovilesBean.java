package ec.edu.ups.paul_idrovo_servidor.view;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.paul_idrovo_servidor.model.Automovil;
import ec.edu.ups.ppw.ppw59.business.GestionAutomoviles;



@Named
@RequestScoped
public class AutomovilesBean {
	
	@Inject
	private GestionAutomoviles facON;
	
	private String placa;
	private String marca;
	private String color;	
	private String anio;
	
	private Automovil newAutomovil = new Automovil();
	
	private String filtro;
	
	private List<Automovil> automoviles;
	
	
	public void init() {
		automoviles = facON.getAutomoviles();
	}	
	
	
	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getAnio() {
		return anio;
	}


	public void setAnio(String anio) {
		this.anio = anio;
	}


	public Automovil getNewAutomovil() {
		return newAutomovil;
	}


	public void setNewAutomovil(Automovil newAutomovil) {
		this.newAutomovil = newAutomovil;
	}


	public List<Automovil> getAutomoviles() {
		return automoviles;
	}


	public void setAutomoviles(List<Automovil> automoviles) {
		this.automoviles = automoviles;
	}


	public String guardar() {
//		System.out.println(this.cedula + " " + this.nombre);
		
//		Persona p = new Persona();
//		newCliente.setNombre(nombre);
//		newCliente.setCedula(cedula);
//		newCliente.setDireccion(direccion);
		
		System.out.println("automovil ? " + newAutomovil.getPlaca());
		facON.guardarAutomovil(newAutomovil);
		this.init();
		
		return "Listado-cliente";
	}
	
	public String buscarPorNombre() {
		System.out.println("Ingreso a buscar");
		automoviles = facON.getAutomovilesPlaca(this.filtro);
		return null;
	}
	
	public String editarAutomovil(String id) {
		System.out.println("editando " + id);
		return "Crear-Automovil?faces-redirect=true&id="+id;
	}
	/*
	public void loadDatos() {
		if(placa==null) {
			return;
		}
		Automovil a = facON.getAutomovil(placa);
		color = a.getColor();
		marca = a.getPlaca();
		anio=a.getAnio();

		newAutomovil = a;
	}*/
	
}
