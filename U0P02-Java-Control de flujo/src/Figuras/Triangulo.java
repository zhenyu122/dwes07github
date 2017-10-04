package Figuras;

import java.util.Scanner;

public class Triangulo extends Figura{

	Scanner s=new Scanner(System.in);
	private double base;
	private double altura;
	
	public Triangulo(String titulo,Color color,int base,int altura) {
		super(titulo, color);
		this.base=base;
		this.altura=altura;
	}
	
	public double area() {
		return (base*altura)/2;
	}
	
	public double perimetro() {
		return base+altura+Math.sqrt(Math.pow(base, 2)+Math.pow(altura, 2));
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Triangulo ["+super.toString()+" base=" + base + ", altura=" + altura + ", area()=" + area() + ", perimetro()=" + perimetro()
				+ "]";
	}


}
