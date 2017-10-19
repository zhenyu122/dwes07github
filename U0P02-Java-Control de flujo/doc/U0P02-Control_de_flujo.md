---
typora-copy-images-to: imagenes
---

###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U0P02 - Repaso: estructuras de control de flujo
#### Entrega de: Zhenyu Guo
----
#### 1. Descripción:

Vamos a instalar el Java Develompent Kit (JDK) y el entorno de desarrollo Eclipse. A continuación crearemos un proyecto Java en el que practicaremos las estructuras de control de flujo (tanto de selección como de iteración) a través de diferentes programas.

#### 2. Formato de entrega:

Completa este documento incluyendo tras cada apartado el código necesario para resolver el problema (sin incluir el método `main`, sólo el código correspondiente a la solución) y el resultado de una ejecución.

* Para el código utiliza bloques de código Markdown
* Para el resultado puedes utilizar también bloques, o bien incluir capturas de pantalla de Eclipse

#### 3. Trabajo a realizar:

Antes de comenzar, escribe tu / vuestros nombres en la cabecera de este documento

##### Parte 1: Configuración del espacio de trabajo en la máquina virtual de Windows 

1. Desinstala la versión actual de Java. Recuerda que normalmente cuando decimos que un ordenador "tiene instalado Java" lo que en realidad tiene instalado es el Java Runtime Environment (JRE).

2. Descarga la última versión del [Java Development Kit (JDK)](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html): Java 8 Update 144. Localiza la descarga en la web oficial, pero si lo deseas puedes descargar el archivo desde el FTP del instituto. **Utilizaremos esta versión de Java durante todo el curso. Es muy importante que tengas la misma en casa y no la actualices para evitar problemas al compartir proyectos posteriormente**.

3. Desde el menú de inicio, abre el panel de configuración de Java (`Configurar Java`). Recuerda: hablamos del JRE. El JDK no tiene ninguna aplicación gráfica

4. Comprueba que la versión es la esperada haciendo clic en el botón `Acerca de` en la pestaña `General`

   ![1505984452163](imagenes/1505984452163.png)

5. En la pestaña `Actualizar` desmarca la casilla *Comprobar actualizaciones automáticamente*. Esto garantizará que todos tengamos la misma versión de Java a lo largo del curso.

6. Descarga la última versión de Eclipse, llamada Oxygen. Como más adelante desarrollaremos aplicaciones Java EE, no queremos el paquete básico de instalación: en la [web de descargas de Eclipse](http://www.eclipse.org/downloads/) debes hacer clic en *Download Packages* y escoger la edición para desarrolladores Java EE. Tienes el archivo disponible en el servidor FTP del instituto.

7. Descomprime el archivo de forma que la carpeta llamada `eclipse` (sin la versión) quede donde desees, por ejemplo en la raíz `C:\`

8. Crea un acceso directo al ejecutable de Eclipse en el escritorio y/o en la barra de tareas

   ![1505985200552](imagenes/1505985200552.png)

9. Ejecuta Eclipse: la primera decisión será la ubicación de la carpeta de espacio de trabajo o *workspace*: puedes dejar la que viene por defecto o escoger otra a tu gusto

   ![1505985280667](imagenes/1505985280667.png)

10. Inicialmente aparecerá la pantalla de bienvenida: desmarca la casilla para que no vuelva a aparecer en el futuro

#####Parte 2: Creación y organización de un proyecto

1. Crea un nuevo proyecto Java: `File` → `New` → `Project` → `Java Project`. El nombre es importante, puesto que seguiremos la misma nomenclatura durante todo el curso: *Número de práctica - Lenguaje utilizado - Título o descripción*, en este caso: *U0P02-Java-Control de flujo* 

   ![1505987208723](imagenes/1505987208723.png)

2. Crea desde Eclipse una carpeta `doc` en la raíz del proyecto (junto a la carpeta `src`) y copia en ella el archivo de este enunciado (arrastra el archivo a la carpeta de Eclipse). A lo largo del curso seguiremos este esquema para agrupar cada proyecto con su correspondiente enunciado.

   ![1505987503687](imagenes/1505987503687.png)

3. Indica que queremos editar los archivos Markdown con Typora: *clic secundario sobre el archivo → Open with → Other → Browse → Localizar el ejecutable de Typora en la carpeta de archivos de programa*. No olvides marcar la casilla para indicar que queremos utilizar este programa para abrir todos los archivos Markdown

4. Comprueba que al hacer doble clic sobre un archivo Markdown en Eclipse, se abre con Typora

5. Crea una clase *HolaMundo* con un código sencillo para probar que tu instalación de Java es correcta y puedes compilar y ejecutar programas en Java. 

6. Recuerda que dispones de plantillas de código para escribir rápidamente sentencias o bloques. Por ejemplo si escribes "sout" y pulsas Ctrl + Espacio, se escribirá `System.out.println();`. También hay plantillas para escribir un bloque if-else, while, try-catch... Consulta las plantillas en `Window` → `Preferences` → `Java` → `Editor` → `Templates`


#####Parte 3: Repaso de Java: estructuras de control de flujo

Crea un paquete llamado `ControlDeFlujo` y codifica en una o varias clases los siguientes programas:

1) Preguntar al usuario el día de la semana e indicar si es laborable o no. Resolver utilizando la estructura `switch`.

- *Código*:

```java
Scanner s=new Scanner(System.in);
		System.out.println("¿Qué dia de la semana es?");
		String dia=s.nextLine();
		dia=dia.toLowerCase();
		System.out.print(dia);
		switch(dia) {
			case "lunes":case "martes":	case "miercoles":
			case "jueves":	case "viernes":
				System.out.println(" es laborable");
				break;
			case "sabado":	case "domingo":
				System.out.println(" no es laborable");
				break;
			default:
				System.out.println(" no es un dia de la semana");
				break;
			
		}
```

- *Ejecución*:

        ¿Qué dia de la semana es?
        jueves
        jueves es laborable
        ¿Qué dia de la semana es?
        domingo
        domingo no es laborable


2) Pedir al usuario cinco cadenas de texto y generar una sola cadena uniéndolas todas. Escribir esa cadena por pantalla.

- *Código*:

  ```java
  	Scanner s=new Scanner(System.in);
  		System.out.println("Introduce 5 cadenas");
  		String cadena=a;
  		for (int i=0;i<5;i++) {
  			String a=s.nextLine();
  			cadena=cadena.concat(a);
  		}
  		System.out.println(cadena);
  ```

- *Ejecución*:

  ```
  Introduce 5 cadenas
  esto
  puede
  ser
  una
  prueba
  estopuedeserunaprueba
  ```


3) Ir pidiendo por teclado una serie de números enteros e irlos sumando. Se deja de pedir números al usuario cuando la cantidad supera el valor 50. Escribir por pantalla la suma de todos los números introducidos.

- *Código*:

  ````java
  Scanner s=new Scanner(System.in);
  		int a,total=0;
  		do{
  			System.out.println("Introduce un número");
  			a=s.nextInt();
  			total+=a;
  			System.out.println("El total es "+total);
  		}while(total<50);
  ````

  ​

- *Ejecución*:

  ```
  Introduce un número
  5
  El total es 5
  Introduce un número
  5
  El total es 10
  Introduce un número
  4
  El total es 14
  Introduce un número
  1
  El total es 15
  Introduce un número
  35
  El total es 50
  ```

  ​

4) Pedir al usuario un número. Si introduce un valor inválido (por ejemplo una letra), se le volverá a solicitar que introduzca el número. 

Cuando termines, añade a continuación una expansión de este problema: pedir al usuario un número entre el 1 y el 10, pidiéndolo de nuevo si lo introduce mal.

Observa que estos dos bloques de código pueden ser reutilizados en cualquier punto de tus futuros programas en el que desees leer un número.


- *Código*:

  ```java

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
  ```

  ​

- *Ejecución*:

  ```
  Introduce un número
  a
  Valor invalido
  Introduce un número
  4
  Has introducido: 4
  Introduce un número del 1 al 10
  x
  Valor invalido
  Introduce un número del 1 al 10
  11
  Introduce un número del 1 al 10
  0
  Introduce un número del 1 al 10
  6
  Has introducido: 6
  ```

  ​

5) Preguntar al usuario un número de mes (del 1 al 12) y preguntar si el año es bisiesto (sí o no). Escribir su número de días. Si los datos no están bien introducidos se volverán a pedir. Utilizar estructura `switch`.

- *Código*:

  ```java
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
  ```

  ​

- *Ejecución*:

  ````
  Introduce un número de mes
  1
  ¿Es bisiesto?
  no
  31 dias
  Introduce un número de mes
  2
  ¿Es bisiesto?
  no
  28 dias
  Introduce un número de mes
  2
  ¿Es bisiesto?
  si
  29 dias
  ````

  ​

6) Pedir al usuario dos números “a” y “b” entre el 1 y el 10. Mientras uno de ellos sea menor que el otro, escribir un símbolo “*” en la pantalla e incrementar en una unidad el número menor.

- *Código*:

  ````java
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
  ````

  ​

- *Ejecución*:

  ````
  Introduce dos números entre el 1 y el 10
  5
  3
  *
  4
  *
  5
  ````

  ​

7) Pedir al usuario un número entero y calcular el factorial de dicho número usando la estructura “do-while”. Repetir el ejercicio usando la estructura “while”, y repetirlo una vez más usando la estructura “for”.

- *Código (las tres versiones seguidas)*:

  ````java
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
  ````

- *Ejecución*:

  ````
  Introduce un numero entero
  5
  Con do-while
  120
  Con while
  120
  Con for
  120
  ````

  ​

8) Basándote en la estructura `do-while`, diseña un menú de dos niveles, es decir: en un primer momento se pedirá escoger entre varias opciones, y en cada una de ellas se pedirá de nuevo escoger entre un nuevo conjunto. La temática es libre (cálculo de áreas, enciclopedia, etc). Es importante que tu programa reaccione correctamente ante entradas erróneas del usuario, y que en todos los menús haya una opción para volver.

  Ten en cuenta que codificar un menú correctamente no es trivial, conviene que pienses lo que vas a hacer antes de empezar a codificar.

**- *Código*:**

````java
Scanner s=new Scanner(System.in);
		int x1,x2;
		do {
			System.out.println("Introduce :");
			System.out.println("1 para DAW");
			System.out.println("2 para ASIR");
			System.out.println("3 para salir");
			x1=s.nextInt();
			switch (x1) {
			case 1:
				do {
					System.out.println("Has entrado en DAW");
					System.out.println("Introduce :");
					System.out.println("1 para DWES");
					System.out.println("2 para DWEC");
					System.out.println("3 para volver");
					x2=s.nextInt();
					switch (x2) {
					case 1:
						System.out.println("Has entrado en el DWES");
						System.out.println();
						break;
					case 2:
						System.out.println("Has entrado en el DWEC");
						System.out.println();
						break;
					}
				}while(x2!=3);
				break;
			case 2:
				do {
					System.out.println("Has entrado en ASIR");
					System.out.println("Introduce :");
					System.out.println("1 para ISO");
					System.out.println("2 para PAR");
					System.out.println("3 para volver");
					x2=s.nextInt();
					switch (x2) {
					case 1:
						System.out.println("Has entrado en ISO");
						System.out.println();
						break;
					case 2:
						System.out.println("Has entrado en PAR");
						System.out.println();
						break;
					}
				}while(x2!=3);
				break;
			}
		}while(x1!=3);
````

- *Ejecución*:
````
Introduce :
1 para DAW
2 para ASIR
3 para salir
1
Has entrado en DAW
Introduce :
1 para DWES
2 para DWEC
3 para volver
1
Has entrado en el DWES

Has entrado en DAW
Introduce :
1 para DWES
2 para DWEC
3 para volver
2
Has entrado en el DWEC

Has entrado en DAW
Introduce :
1 para DWES
2 para DWEC
3 para volver

3
Introduce :
1 para DAW
2 para ASIR
3 para salir
2
Has entrado en ASIR
Introduce :
1 para ISO
2 para PAR
3 para volver
1
Has entrado en ISO

Has entrado en ASIR
Introduce :
1 para ISO
2 para PAR
3 para volver
2
Has entrado en PAR

Has entrado en ASIR
Introduce :
1 para ISO
2 para PAR
3 para volver
3
Introduce :
1 para DAW
2 para ASIR
3 para salir
3
````



9) (opcional) Inventa un problema sencillo sobre estructuras de control de flujo. Resuélvelo para comprobar que el nivel de dificultad es adecuado y comparte el enunciado con tu compañer@ de al lado. Incluye aquí tanto tu enunciado como la solución.

- *Enunciado*: 

  ````
  Muestra los numeros primos del 1 al 20.
  ````

  ​

- *Código de la solución*

  ````java
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
  ````

  ​

- *Ejecución*:

  ````
  El 1 es primo
  El 2 es primo
  El 3 es primo
  El 4 no es primo
  El 5 es primo
  El 6 no es primo
  El 7 es primo
  El 8 no es primo
  El 9 no es primo
  El 10 no es primo
  El 11 es primo
  El 12 no es primo
  El 13 es primo
  El 14 no es primo
  El 15 no es primo
  El 16 no es primo
  El 17 es primo
  El 18 no es primo
  El 19 es primo
  El 20 no es primo

  ````

  ​

10) (opcional) Resuelve el problema que tu compañer@ plantee.

- *Enunciado de tu compañer@:*

  ````
  Pedir al usuario una cadena y mostrar por pantalla si es palindroma.
  ````

- *Código de la solución*

  ````
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
  ````

- *Ejecución*:

  ````
  Introduce una cadena
  asd asd dsa dsa
  Es palindroma

  Introduce una cadena
  asdf asda
  No es
  ````

  ​