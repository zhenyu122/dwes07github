package Figuras;

import java.util.Scanner;

public class Cuadrado {
	Scanner s=new Scanner(System.in);
	private double lado;
	
	public Cuadrado(double lado) {
		this.lado=lado;
	}
	
	public double area() {
		return Math.pow(lado, 2);
	}

	public double perimetro() {
		return 4*lado;
	}
	
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + ", area()=" + area() + ", perimetro()=" + perimetro() + "]";
	}


}
