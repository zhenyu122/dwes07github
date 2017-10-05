package Figuras;

import java.util.Scanner;

public class Triangulo extends Figura{

	Scanner s=new Scanner(System.in);
	private double base;
	private double altura;
	/**
	 * Constructor de la clase Triángulo
	 * @param titulo Define el nombre que tendra la Triángulo
	 * @param color Define el color que tendrá la Triángulo
	 * @param base Define la base del Triángulo
	 * @param altura Define la altura del Triángulo
	 * **/
	public Triangulo(String titulo,Color color,int base,int altura) {
		super(titulo, color);
		this.base=base;
		this.altura=altura;
	}
	/**
	 * Método heredado para calcular el área del Triángulo
	 * @return El área del Triángulo
	 * **/
	public double area() {
		return (base*altura)/2;
	}
	/**
	 * Método heredado para calcular el perimetro del Triángulo
	 * @return El perimetro del Triángulo
	 * **/
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
	/**
	 * Método para mostrar los datos del Triángulo
	 * @return Datos del Triángulo
	 * **/
	@Override
	public String toString() {
		return "Triangulo ["+super.toString()+" base=" + base + ", altura=" + altura + ", area()=" + area() + ", perimetro()=" + perimetro()
				+ "]";
	}


}
