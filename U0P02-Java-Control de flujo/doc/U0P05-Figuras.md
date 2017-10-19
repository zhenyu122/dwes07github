##### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U0P05 - Figuras
#### Entrega de: *Zhenyu Guo*
----

#### 1. Descripción:

Vamos a utilizar el enfoque orientado a objetos para solucionar un problema trigonométrico, repasando conceptos como clases y objetos, herencia y polimorfismo, colecciones, o JavaDoc.

#### 2. Formato de entrega:

Incluye al final de este documento el código de las clases que hayas programado, así como el resultado de ejecución.

Puedes utilizar bloques de código Markdown o capturas de Eclipse.

#### 3. Trabajo a realizar:

#### Parte 1: Clases y objetos

Crea un paquete llamado `figuras` y codifica las clases Cuadrado, Triangulo y Circunferencia. Incluye en todas un método para imprimir sus datos. Después codifica una clase *Problema* que calcule el área y el perímetro de la siguiente figura:

![](U0P05-1.png "...")

##### Código de la clase Cuadrado:

```java
Scanner s=new Scanner(System.in);
	private double lado;
	
	public Cuadrado(double lado) {
		this.lado=lado;
	}
	
	public double area() {
		return Math.pow(lado, 2);
	}

	public double perimetro() {
		return 4*lado;
	}
	
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + ", area()=" + area() + ", perimetro()=" + perimetro() + "]";
	}

```

##### Código de la clase Triángulo:

````java
Scanner s=new Scanner(System.in);
	private double base;
	private double altura;
	
	public Triangulo(int base,int altura) {
		this.base=base;
		this.altura=altura;
	}
	
	public double area() {
		return (base*altura)/2;
	}
	
	public double perimetro() {
		return base+altura+Math.sqrt(Math.pow(base, 2)+Math.pow(altura, 2));
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Triangulo [base=" + base + ", altura=" + altura + ", area()=" + area() + ", perimetro()=" + perimetro()
				+ "]";
	}
````

##### Código de la clase Circunferencia:

````` java
private double radio;
	Scanner s=new Scanner(System.in);
	
	public Circunferencia(double radio) {
		this.radio=radio;
	}

	public double area() {
		return Math.PI*Math.pow(getRadio(), 2);
	}
	
	public double perimetro() {
		return 2*Math.PI*getRadio();
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public String toString() {
		return "Circunferencia [radio=" + radio + ", area()=" + area() + ", perimetro()=" + perimetro() + "]";
	}

`````

##### Código del método main en la clase Problema:

````java
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
````

##### Ejecución del método main:

````
Circunferencia [radio=4.8, area()=72.38229473870884, perimetro()=30.159289474462014]
Circunferencia [radio=1.5, area()=7.0685834705770345, perimetro()=9.42477796076938]
Cuadrado [lado=4.2, area()=17.64, perimetro()=16.8]
Triangulo [base=8.0, altura=15.0, area()=60.0, perimetro()=40.0]

El area de la figura es 119.13258497228719
El perimetro de la figura es 57.948228207808036
````

#### Parte 2: Herencia

Queremos que todas las figuras tengan un título y un color. Para el color puedes utilizar un tipo enumerado Color con al menos cinco valores.

1. Define una clase Figura con estos nuevos atributos
- Haz que nuestras clases de figuras hereden dichos atributos
- ¿Crees que la clase Figura debería ser abstracta? ¿Y los métodos de calcular áreas y perímetros? Si es así haz las modificaciones necesarias
- Utilizando la *reescritura*, haz que de cada figura se impriman en pantalla tanto sus atributos heredados (color y título) como los propios de esa figura particular.
- Crea una clase Principal con un método main en el que instancies diferentes figuras por este procedimiento y escribas sus datos por pantalla.

##### Código de la clase Figura:

````java
public abstract class Figura {

	private String titulo;
	private Color color;
	
	public Figura(String titulo,Color c) {
		this.titulo=titulo;
		color=c;
	}

	@Override
	public String toString() {
		return "titulo=" + titulo + ", color=" + color;
	}

	public double area() {
		return 0;
	}

	public double perimetro() {
		return 0;
	}
	
}
````

##### Código de la clase Cuadrado una vez modificada:

````java
public class Cuadrado extends Figura{
	Scanner s=new Scanner(System.in);
	private double lado;
	
	public Cuadrado(String titulo,Color color,double lado) {
		super(titulo,color);
		this.lado=lado;
	}
	
	public double area() {
		return Math.pow(lado, 2);
	}

	public double perimetro() {
		return 4*lado;
	}
	
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public String toString() {
		return "Cuadrado ["+super.toString()+" lado=" + lado + ", area()=" + area() + ", perimetro()=" + perimetro() + "]";
	}
}
````
##### Código del método main en la clase Principal:

````java
		Circunferencia c1=new Circunferencia("c1", Color.Azul, 4.8);
		Circunferencia c2=new Circunferencia("c2", Color.Naranja, 1.5);
		Cuadrado cua=new Cuadrado("cuadrado", Color.Rojo,4.2);
		Triangulo t=new Triangulo("tringulo", Color.Negro,8, 15);
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
````
##### Ejecución del método main:

````
Circunferencia [titulo=c1, color=Azul radio=4.8, area()=72.38229473870884, perimetro()=30.159289474462014]
Circunferencia [titulo=c2, color=Naranja radio=1.5, area()=7.0685834705770345, perimetro()=9.42477796076938]
Cuadrado [titulo=cuadrado, color=Rojo lado=4.2, area()=17.64, perimetro()=16.8]
Triangulo [titulo=tringulo, color=Negro base=8.0, altura=15.0, area()=60.0, perimetro()=40.0]

El area de la figura es 119.13258497228719

El perimetro de la figura es 57.948228207808036
````
#### Parte 3: Colecciones

1. Codifica una clase GestorFiguras con un único atributo (un ArrayList de figuras) y los siguientes métodos, teniendo cuidado de documentar con código JavaDoc:
  - **constructor**: no recibirá ningún valor pero inicializará el ArrayList
  - **añadirFigura**: recibirá un objeto de la clase Figura y lo añadirá a la lista siempre que no tenga el mismo título
  - **eliminarFigura**: eliminará una figura a partir de su título
  - **mostrarFiguras**: escribirá por pantalla de forma ordenada los datos de todas las figuras del gestor
  - **calcularSumatorioAreas**: escribirá la suma de las áreas de todas las figuras

2. Modifica el método main de la clase Principal para crear un gestor de figuras y hacer pruebas con él: añadir alguna, eliminarla, imprimirlas... 

##### Código de la clase GestorFiguras:

````java
public class GestorFiguras {
	private ArrayList<Figura>ar;
	
	public GestorFiguras() {
		ar=new ArrayList<>();
	}
	
	public void añadirFigura(Figura f) {
		boolean enc=false;
		for (int i=0;i<ar.size() && !enc;i++) {
			if(ar.get(i).getTitulo().equalsIgnoreCase(f.getTitulo())) {
				enc=true;
				System.out.println("Ya existe ese titulo");
			}
		}
		if (!enc) {
			ar.add(f);
			System.out.println("Figura añadida");
		}
	}
	
	public void eliminarFigura(String titulo) {
		boolean enc=false;
		for (int i=0;i<ar.size() && !enc;i++) {
			if (ar.get(i).getTitulo().equalsIgnoreCase(titulo)) {
				enc=true;
				ar.remove(i);
				System.out.println("Figura Borrada");
			}
		}
		if (!enc)
			System.out.println("No hay una figura con ese titulo");
	}
	
	public void mostrarFiguras() {
		Collections.sort(ar);
		for (int i=0;i<ar.size();i++) {
			System.out.println(ar.get(i).toString());
		}
	}
	
	public double calcularSumatorioAreas() {
		double suma=0;
		for (int i=0;i<ar.size();i++) {
			System.out.println("El area de "+ar.get(i).getTitulo()+" es "+ar.get(i).area());
			suma+=ar.get(i).area();
		}
		return suma;
	}
	
}
````

##### Código del método main en la clase Principal:

````java
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
		System.out.println("Añadimos las figuras y comprobamos que no añade si el titulo existe");
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
````

##### Ejecución del método main:

````
Circunferencia [titulo=c1, color=Azul radio=4.8, area()=72.38229473870884, perimetro()=30.159289474462014]
Circunferencia [titulo=c2, color=Naranja radio=1.5, area()=7.0685834705770345, perimetro()=9.42477796076938]
Cuadrado [titulo=cuadrado, color=Rojo lado=4.2, area()=17.64, perimetro()=16.8]
Triangulo [titulo=tringulo, color=Negro base=8.0, altura=15.0, area()=60.0, perimetro()=40.0]

El area de la figura es 119.13258497228719

El perimetro de la figura es 57.948228207808036

Añadimos las figuras y comprobamos que no añade si el titulo existe
Figura añadida
Figura añadida
Figura añadida
Figura añadida
Ya existe ese titulo

Mostramos las figuras
Circunferencia [titulo=c1, color=Azul radio=4.8, area()=72.38229473870884, perimetro()=30.159289474462014]
Circunferencia [titulo=c2, color=Naranja radio=1.5, area()=7.0685834705770345, perimetro()=9.42477796076938]
Cuadrado [titulo=cuadrado, color=Rojo lado=4.2, area()=17.64, perimetro()=16.8]
Triangulo [titulo=tringulo, color=Negro base=8.0, altura=15.0, area()=60.0, perimetro()=40.0]

El area de c1 es 72.38229473870884
El area de c2 es 7.0685834705770345
El area de cuadrado es 17.64
El area de tringulo es 60.0
La suma de las areas de todas las figuras es 157.09087820928588

Eliminamos una figura y volvemos a mostrar
Figura Borrada
Circunferencia [titulo=c2, color=Naranja radio=1.5, area()=7.0685834705770345, perimetro()=9.42477796076938]
Cuadrado [titulo=cuadrado, color=Rojo lado=4.2, area()=17.64, perimetro()=16.8]
Triangulo [titulo=tringulo, color=Negro base=8.0, altura=15.0, area()=60.0, perimetro()=40.0]
````

