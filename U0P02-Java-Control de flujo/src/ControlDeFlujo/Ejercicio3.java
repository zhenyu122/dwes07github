package ControlDeFlujo;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		int a,total=0;
		do{
			System.out.println("Introduce un número");
			a=s.nextInt();
			total+=a;
			System.out.println("El total es "+total);
		}while(total<50);
		
	}

}
