package Figuras;

public abstract class Figura {

	private String titulo;
	private Color color;
	
	public Figura(String titulo,Color c) {
		this.titulo=titulo;
		color=c;
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
	
}
