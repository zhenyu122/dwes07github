package Figuras;

import java.util.Scanner;

public class Cuadrado extends Figura{
	Scanner s=new Scanner(System.in);
	private double lado;
	/**
	 * Constructor de la clase Cuadrado
	 * @param titulo Define el nombre que tendra la Cuadrado
	 * @param color Define el color que tendrá la Cuadrado
	 * @param lado Define el lado del Cuadrado
	 * **/
	public Cuadrado(String titulo,Color color,double lado) {
		super(titulo,color);
		this.lado=lado;
	}
	/**
	 * Método heredado para calcular el área del cuadrado
	 * @return El área del circunferencia
	 * **/
	public double area() {
		return Math.pow(lado, 2);
	}
	/**
	 * Método heredado para calcular el perimetro del cuadrado
	 * @return El área del cuadrado
	 * **/
	public double perimetro() {
		return 4*lado;
	}
	
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	/**
	 * Método para mostrar los datos del cuadrado
	 * @return Datos del cuadrado
	 * **/
	@Override
	public String toString() {
		return "Cuadrado ["+super.toString()+" lado=" + lado + ", area()=" + area() + ", perimetro()=" + perimetro() + "]";
	}


}
