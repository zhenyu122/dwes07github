package ControlDeFlujo;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		int a,b;
		do {
			System.out.println("Introduce dos números entre el 1 y el 10");
			a=s.nextInt();
			b=s.nextInt();
		}while(a>10 || a<1 || b>10 || b<1);
		while(a<b || b<a) {
			System.out.println("*");
			if (a<b) {
				a+=1;
				System.out.println(a);
			}else {
				b+=1;
				System.out.println(b);
			}
		}
		
	}

}
