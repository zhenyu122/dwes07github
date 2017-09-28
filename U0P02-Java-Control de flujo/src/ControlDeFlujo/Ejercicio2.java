package ControlDeFlujo;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		System.out.println("Introduce 5 cadenas");
		String cadena="";
		for (int i=0;i<5;i++) {
			String a=s.nextLine();
			cadena=cadena.concat(a);
		}
		System.out.println(cadena);
	}

}
