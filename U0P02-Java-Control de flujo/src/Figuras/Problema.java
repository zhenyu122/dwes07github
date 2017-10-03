package Figuras;

public class Problema {

	public static void main(String[] args) {
		Circunferencia c1=new Circunferencia(4.8);
		Circunferencia c2=new Circunferencia(1.5);
		Cuadrado cua=new Cuadrado(4.2);
		Triangulo t=new Triangulo(8, 15);
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(cua.toString());
		System.out.println(t.toString());
		double area=t.area()+cua.area()+(c1.area()/2+((c2.area()/4)*3));
		System.out.println();
		System.out.println("El area de la figura es "+area);
		double perimetro=((c2.perimetro()/4)*3)+(c1.perimetro()/2)+(cua.perimetro()-cua.getLado())+(t.perimetro()-cua.getLado()-(c1.getRadio()*2)-(c2.getRadio()*2));
		System.out.println("El perimetro de la figura es "+perimetro);
	}

}
