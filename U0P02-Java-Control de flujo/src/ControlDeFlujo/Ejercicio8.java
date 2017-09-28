package ControlDeFlujo;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		int x1,x2;
		do {
			System.out.println("Introduce :");
			System.out.println("1 para DAW");
			System.out.println("2 para ASIR");
			System.out.println("3 para salir");
			x1=s.nextInt();
			switch (x1) {
			case 1:
				do {
					System.out.println("Has entrado en DAW");
					System.out.println("Introduce :");
					System.out.println("1 para DWES");
					System.out.println("2 para DWEC");
					System.out.println("3 para volver");
					x2=s.nextInt();
					switch (x2) {
					case 1:
						System.out.println("Has entrado en el DWES");
						System.out.println();
						break;
					case 2:
						System.out.println("Has entrado en el DWEC");
						System.out.println();
						break;
					}
				}while(x2!=3);
				break;
			case 2:
				do {
					System.out.println("Has entrado en ASIR");
					System.out.println("Introduce :");
					System.out.println("1 para ISO");
					System.out.println("2 para PAR");
					System.out.println("3 para volver");
					x2=s.nextInt();
					switch (x2) {
					case 1:
						System.out.println("Has entrado en ISO");
						System.out.println();
						break;
					case 2:
						System.out.println("Has entrado en PAR");
						System.out.println();
						break;
					}
				}while(x2!=3);
				break;
			}
		}while(x1!=3);
	}

}
