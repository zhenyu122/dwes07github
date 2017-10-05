package Figuras;

public abstract class Figura implements Comparable<Figura> {

	private String titulo;
	private Color color;
	/**
	 * Constructor de la clase Figura
	 * @param titulo Define el nombre que tendra la Figura
	 * @param color Define el color que tendrá la Figura
	 * @param titulo Define el titulo de la Figura
	 * **/
	public Figura(String titulo,Color c) {
		this.titulo=titulo;
		color=c;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public Color getColor() {
		return color;
	}
	/**
	 * Método para mostrar los datos del cuadrado
	 * @return Datos de la figura
	 * **/
	@Override
	public String toString() {
		return "titulo=" + titulo + ", color=" + color;
	}

	public double area() {
		return 0;
	}

	public double perimetro() {
		return 0;
	}
	public int compareTo(Figura o) {
		return this.getTitulo().compareTo(o.getTitulo());
	}
}
