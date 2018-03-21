package model;

import java.io.Serializable;

public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int chip;
	private String nombre;
	private String especie;
	private String imagen;
	
	public Animal(int chip, String nombre, String especie, String imagen) {
		super();
		this.chip = chip;
		this.nombre = nombre;
		this.especie = especie;
		this.imagen = imagen;
	}
	public int getChip() {
		return chip;
	}
	public void setChip(int chip) {
		this.chip = chip;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
