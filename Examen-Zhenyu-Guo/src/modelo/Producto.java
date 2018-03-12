package modelo;

import java.io.Serializable;

public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	int id,stock;
	String nombre,marca;
	double precio;
	
	public Producto(int id,String nombre,String marca,double precio,int stock) {
		this.id=id;
		this.nombre=nombre;
		this.marca=marca;
		this.precio=precio;
		this.stock=stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
