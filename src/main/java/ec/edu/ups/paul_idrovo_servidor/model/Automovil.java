package ec.edu.ups.paul_idrovo_servidor.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Automovil {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String placa;
	private String marca;
	private String color;	
	private String anio;
	
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
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	
	
	
	
}
