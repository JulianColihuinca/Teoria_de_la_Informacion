package back.domain.calculadoras;

import java.util.ArrayList;
import java.util.Arrays;

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

	public double[][] getProbabilidadesSimuladas(String simulacion, int cantSimbolos) {
		char[] chars = simulacion.toCharArray();
		double[][] auxMatrizProbabilidades = new double[cantSimbolos][cantSimbolos];
		int asciiValueForFirstChar = 65;

		if (chars.length != 0) {
			char previousChar = chars[0];
			for (int i = 0; i < chars.length; i++) {
				int previousIndex = previousChar - asciiValueForFirstChar;
				int currentIndex = chars[i] - asciiValueForFirstChar;
				auxMatrizProbabilidades[previousIndex][currentIndex] += 1;
				previousChar = chars[i];
			}
		}
		
		return divideMatrixFor(simulacion.length(), auxMatrizProbabilidades);
	}

	private double[][] divideMatrixFor(int divisor, double[][] matrix) {
		double[][] result = matrix;

		for (int i = 0; i < matrix.length ; i++) {
			for (int j = 0; j < matrix.length ; j++) {
				result[i][j] /= divisor;
			}
		}
		return result;
	}
}
