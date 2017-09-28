package ControlDeFlujo;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		System.out.println("Introduce un numero entero");
		int entero=s.nextInt();
		int factorial=1;
		int x=entero;
		System.out.println("Con do-while");
		do {
			factorial*=x;
			x--;
		}while(x>=1);
		System.out.println(factorial);
		System.out.println("Con while");
		factorial=1;x=entero;
		while(x>=1) {
			factorial*=x;
			x--;
		}
		System.out.println(factorial);
		System.out.println("Con for");
		factorial=1;x=entero;
		for (int i=1;i<=x;i++) {
			factorial*=i;
		}
		System.out.println(factorial);
	}

}
