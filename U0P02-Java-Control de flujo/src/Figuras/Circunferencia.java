package Figuras;

import java.util.Scanner;

public class Circunferencia extends Figura{
	Scanner s=new Scanner(System.in);
	private double radio;
	
	public Circunferencia(String titulo,Color color,double radio) {
		super(titulo, color);
		this.radio=radio;
	}

	public double area() {
		return Math.PI*Math.pow(getRadio(), 2);
	}
	
	public double perimetro() {
		return 2*Math.PI*getRadio();
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public String toString() {
		return "Circunferencia ["+super.toString()+" radio=" + radio + ", area()=" + area() + ", perimetro()=" + perimetro() + "]";
	}

	

	
	
	

}
