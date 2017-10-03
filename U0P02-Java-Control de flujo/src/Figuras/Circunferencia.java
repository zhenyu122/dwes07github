package Figuras;

import java.util.Scanner;

public class Circunferencia {

	private double radio;
	Scanner s=new Scanner(System.in);
	
	public Circunferencia(double radio) {
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
		return "Circunferencia [radio=" + radio + ", area()=" + area() + ", perimetro()=" + perimetro() + "]";
	}

	
	
	

}
