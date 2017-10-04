package Figuras;

public abstract class Figura implements Comparable<Figura> {

	private String titulo;
	private Color color;
	
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
