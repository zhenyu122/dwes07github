package Figuras;

import java.util.ArrayList;
import java.util.Collections;

public class GestorFiguras {
	private ArrayList<Figura>ar;
	/**
	 * Constructor de la clase GestorFiguras
	 * @param ar Inicializamos el array 
	 * **/
	public GestorFiguras() {
		ar=new ArrayList<>();
	}
	/**
	 * Método para añadir una figura al array
	 * @param f Define el objeto que le pasamos al metodo para añadir al array
	 * **/
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
	/**
	 * Método para eliminar una figura del array
	 * @param titulo Define el titulo por el que se buscará la figura para eliminar
	 * **/
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
	/**
	 * Método para mostar los datos de todas las figuras del array
	 * **/
	public void mostrarFiguras() {
		Collections.sort(ar);
		for (int i=0;i<ar.size();i++) {
			System.out.println(ar.get(i).toString());
		}
	}
	/**
	 * Método para calcular la suma del area de todas las figuras del array
	 * @return La suma de las areas de todas las figuras
	 * **/
	public double calcularSumatorioAreas() {
		double suma=0;
		for (int i=0;i<ar.size();i++) {
			System.out.println("El area de "+ar.get(i).getTitulo()+" es "+ar.get(i).area());
			suma+=ar.get(i).area();
		}
		return suma;
	}
	
}


