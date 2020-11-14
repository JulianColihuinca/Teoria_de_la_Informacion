package back.domain.calculadoras;

import java.util.ArrayList;

public class CalculadoraDeSimulacionFuenteMarkov {

	// Genera la secuencia de caracteres con las probabilidades administradas por la
	// c�tedra
	public String invoke(double[][] probabilidades, int cantidad) {
		String secuencia = "";
		int cantidadDeProbabilidades = probabilidades.length;
		int filaActual = (int) (Math.random() * cantidadDeProbabilidades);
		double random, acumulador;
		int posicion;

		// Primer simbolo
		char simbolo = 'A';
		simbolo += filaActual;

		// Demas simbolos
		for (int i = 0; i < cantidad - 1; i++) {
			posicion = 0;
			random = Math.random();
			acumulador = probabilidades[posicion][filaActual];

			simbolo = 'A';
			while (posicion < cantidadDeProbabilidades && acumulador < random) {
				posicion++;
				acumulador += probabilidades[posicion][filaActual];
			}
			simbolo += posicion;
			secuencia += simbolo;
			filaActual = posicion;
		}
		return secuencia;
	}

	// M�todo encargado de contar las apariciones de cada simbolo en la simulaci�n
	public ArrayList<Integer> invoke(String simulacion, int cantidadSimbolos) {
		ArrayList<Integer> cantidades = new ArrayList<Integer>();
		char aux = 'A';

		for (int i = 0; i < cantidadSimbolos; i++)
			cantidades.add(0);

		for (int i = 0; i < simulacion.length(); i++)
			cantidades.set(simulacion.charAt(i) - aux, cantidades.get(simulacion.charAt(i) - aux) + 1);

		return cantidades;
	}

	// M�todo encargado de calcular las probabilidades de aparici�n de cada simbolo
	// de acuerdo a su cantidad de apariciones en la simulaci�n
	public ArrayList<Double> invoke(ArrayList<Integer> cantidades) {
		ArrayList<Double> probabilidades = new ArrayList<Double>();

		double total = 0;
		for (int i = 0; i < cantidades.size(); i++)
			total += cantidades.get(i);

		for (int i = 0; i < cantidades.size(); i++)
			probabilidades.add(cantidades.get(i) / total);

		return probabilidades;
	}

}
