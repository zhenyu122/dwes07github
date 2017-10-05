package Figuras;

import java.util.Scanner;

public class Circunferencia extends Figura{
	Scanner s=new Scanner(System.in);
	private double radio;
	/**
	 * Constructor de la clase Circunferencia
	 * @param titulo Define el nombre que tendra la circunferencia
	 * @param color Define el color que tendrá la circunferencia
	 * @param radio Define el radio de la circunferencia
	 * **/
	public Circunferencia(String titulo,Color color,double radio) {
		super(titulo, color);
		this.radio=radio;
	}
	/**
	 * Método heredado para calcular el área del circunferencia
	 * @return El área de la circunferencia
	 * **/
	public double area() {
		return Math.PI*Math.pow(getRadio(), 2);
	}
	/**
	 * Método heredado para calcular el perimetro del circunferencia
	 * @return El perimetro de la circunferencia
	 * **/
	public double perimetro() {
		return 2*Math.PI*getRadio();
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	/**
	 * Método para mostrar los datos de la circunferencia
	 * @return Datos de la circunferencia
	 * **/
	@Override
	public String toString() {
		return "Circunferencia ["+super.toString()+" radio=" + radio + ", area()=" + area() + ", perimetro()=" + perimetro() + "]";
	}

	

	
	
	

}
