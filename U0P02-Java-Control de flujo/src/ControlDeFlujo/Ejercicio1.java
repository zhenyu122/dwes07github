package ControlDeFlujo;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		System.out.println("¿Qué dia de la semana es?");
		String dia=s.nextLine();
		dia=dia.toLowerCase();
		System.out.print(dia);
		switch(dia) {
			case "lunes": case "martes": case "miercoles":
			case "jueves":case "viernes":
				System.out.println(" es laborable");
				break;
			case "sabado":case "domingo":
				System.out.println(" no es laborable");
				break;
			default:
				System.out.println(" no es un dia de la semana");
				break;
			
		}
			
	}

}
