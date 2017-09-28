package ControlDeFlujo;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		boolean valido=true;
		do {
			try{
				valido=true;
				System.out.println("Introduce un número");
				int a=s.nextInt();
				System.out.println("Has introducido: "+a);
			}catch (Exception e) {
				valido=false;
				System.out.println("Valor invalido");
				s=new Scanner(System.in);
			}
		}while(!valido);
		
		int x = 0;
		
		do {
			do {
				try {
					valido=true;
					System.out.println("Introduce un número del 1 al 10");
					x=s.nextInt();
				}catch (Exception e) {
						valido=false;
						System.out.println("Valor invalido");
						s=new Scanner(System.in);
				}
			}while(!valido);
		}while(x>10 || x<1);
		System.out.println("Has introducido: "+x);
	}

}
