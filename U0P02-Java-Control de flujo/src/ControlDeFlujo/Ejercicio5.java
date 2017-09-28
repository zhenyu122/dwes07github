package ControlDeFlujo;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		int mes;boolean bisiesto = false;String a;
		do {
			System.out.println("Introduce un número de mes");
			mes=s.nextInt();
		}while(mes>12 || mes<1);
		s=new Scanner(System.in);
		System.out.println("¿Es bisiesto?");
		a=s.nextLine();
		if (a.equalsIgnoreCase("si"))
			bisiesto=true;
		else if (a.equalsIgnoreCase("no"))
			bisiesto=false;
		int dias=0;
		switch (mes) {
		case 1:	case 3:	case 5:	case 7:	case 8:	case 10:
		case 12:
			dias=31;
			System.out.println("El mes "+mes+" tiene "+dias+" dias");
			break;
		case 2:
			if(bisiesto) {
				dias=29;
				System.out.println("El mes "+mes+" tiene "+dias+" dias");
			}else {
				dias=28;
			System.out.println("El mes "+mes+" tiene "+dias+" dias");
			}
			break;
		case 4:	case 6:	case 9:	case 11:
			dias=30;
			System.out.println("El mes "+mes+" tiene "+dias+" dias");
			break;
			
		}
		
	}

}
