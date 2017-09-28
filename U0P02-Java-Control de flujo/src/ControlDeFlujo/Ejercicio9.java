package ControlDeFlujo;


public class Ejercicio9 {

	public static void main(String[] args) {
		for (int i=1;i<=20;i++){
			boolean primo=true;
		    int x=2;
		    int num=i;
		    while(primo && num/2>=x){
		      if (num%x==0)
		        primo=false;
		      x+=1;
		    }
		    if (primo){
		      System.out.println("El "+num+" es primo");
		    }else{
		      System.out.println("El "+num+" no es primo");
		    }
		}
	}

}
