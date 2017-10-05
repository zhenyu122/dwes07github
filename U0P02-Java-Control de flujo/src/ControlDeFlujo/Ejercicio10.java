package ControlDeFlujo;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		System.out.println("Introduce una cadena");
		String x=s.nextLine();
	    x=x.toLowerCase();
	    for (int i=0;i<x.length();i++){
	        x=x.replace(" ","");
	    }
	    int i=x.length()-1;int y=0;
	    boolean igual=true;
	    while(i>0 && y<x.length()){
	        if (x.charAt(i)!=x.charAt(y)){
	            igual=false;
	        }
	        i--;y++;
	    }
	    if (igual)
	       System.out.println("Es palindroma");
	    else
	        System.out.println("No es");
	}

}
