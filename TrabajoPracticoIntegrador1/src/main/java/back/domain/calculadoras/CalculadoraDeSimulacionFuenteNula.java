package back.domain.calculadoras;

import java.util.ArrayList;

public class CalculadoraDeSimulacionFuenteNula {

	// Genera la secuencia de caracteres con las probabilidades administradas por la
	// cátedra
	public String invoke(ArrayList<Double> probabilidades, int cantidad) {
		int cantidadDeProbabilidades = probabilidades.size();
		char simbolo;
		;
		String secuencia = "";
		double random, acumulador;
		int posicion;
		for (int i = 0; i < cantidad; i++) {
			posicion = 0;
			acumulador = probabilidades.get(0);
			random = Math.random();
			simbolo = 'a';
			while (posicion < cantidadDeProbabilidades && acumulador < random) {
				posicion++;
				acumulador += probabilidades.get(posicion);
			}
			simbolo += posicion;
			secuencia += simbolo;
		}
		return secuencia;
	}

	// Método encargado de contar las apariciones de cada simbolo en la simulación
	public ArrayList<Integer> invoke(String simulacion, int cantidadSimbolos) {
		ArrayList<Integer> cantidades = new ArrayList<Integer>();
		char aux = 'a';
		int[] apariciones = new int[cantidadSimbolos];

		for (int i = 0; i < cantidadSimbolos; i++)
			apariciones[i] = 0;

		for (int i = 0; i < simulacion.length(); i++) {
			apariciones[simulacion.charAt(i) - aux] += 1;
		}

		for (int i = 0; i < cantidadSimbolos; i++)
			cantidades.add(apariciones[i]);

		return cantidades;
	}

	// Método encargado de calcular las probabilidades de aparición de cada simbolo
	// de acuerdo a su cantidad de apariciones en la simulación
	public ArrayList<Double> invoke(ArrayList<Integer> cantidades) {
		ArrayList<Double> probabilidades = new ArrayList<Double>();
		
		double total = 0 ;
		for (int i=0; i<cantidades.size(); i++)
			total+=cantidades.get(i);
		
		for (int i=0; i<cantidades.size(); i++) 
			probabilidades.add(cantidades.get(i)/total);
		
		return probabilidades;
	}
}
