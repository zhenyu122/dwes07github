package Figuras;

public class Main {

	public static void main(String[] args) {
		Circunferencia c1=new Circunferencia("c1", Color.Azul, 4.8);
		Circunferencia c2=new Circunferencia("c2", Color.Naranja, 1.5);
		Cuadrado cua=new Cuadrado("cuadrado", Color.Rojo,4.2);
		Triangulo t=new Triangulo("triangulo", Color.Negro,8, 15);
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(cua.toString());
		System.out.println(t.toString());
		double area=t.area()+cua.area()+(c1.area()/2+((c2.area()/4)*3));
		System.out.println();
		System.out.println("El area de la figura es "+area);
		System.out.println();
		double perimetro=((c2.perimetro()/4)*3)+(c1.perimetro()/2)+(cua.perimetro()-cua.getLado())+(t.perimetro()-cua.getLado()-(c1.getRadio()*2)-(c2.getRadio()*2));
		System.out.println("El perimetro de la figura es "+perimetro);
		System.out.println();
		GestorFiguras g=new GestorFiguras();
		Cuadrado cua2=new Cuadrado("cuadrado", Color.Verde, 5);
		System.out.println("A�adimos las figuras y comprobamos que no a�ade si el titulo existe");
		g.añadirFigura(t);g.añadirFigura(cua);
		g.añadirFigura(c2);g.añadirFigura(c1);
		g.añadirFigura(cua2);
		System.out.println();
		System.out.println("Mostramos las figuras");
		g.mostrarFiguras();
		System.out.println();
		System.out.println("La suma de las areas de todas las figuras es "+g.calcularSumatorioAreas());
		System.out.println();
		System.out.println("Eliminamos una figura y volvemos a mostrar");
		g.eliminarFigura(c1.getTitulo());
		g.mostrarFiguras();
	}

}
