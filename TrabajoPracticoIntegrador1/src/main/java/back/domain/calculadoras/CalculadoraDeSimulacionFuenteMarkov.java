package back.domain.calculadoras;

import java.util.ArrayList;

public class CalculadoraDeSimulacionFuenteMarkov {

	// Genera la secuencia de caracteres con las probabilidades administradas por la
	// cátedra
	public String invoke(double[][] probabilidades, int cantidad) {
		String secuencia = "";
		int cantidadDeProbabilidades = probabilidades.length;
		int filaActual = (int) (Math.random() * cantidadDeProbabilidades);
		double random, acumulador;
		int posicion;

		// Primer simbolo
		char simbolo = 'A';
		simbolo += filaActual;
		secuencia +=simbolo;

		// Demas simbolos
		for (int i = 0; i < cantidad; i++) {
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

	// Método encargado de contar las apariciones de cada simbolo en la simulación
	public ArrayList<Integer> invoke(String simulacion, int cantidadSimbolos) {
		ArrayList<Integer> cantidades = new ArrayList<Integer>();
		char aux = 'A';

		for (int i = 0; i < cantidadSimbolos; i++)
			cantidades.add(0);

		for (int i = 1; i < simulacion.length(); i++)
			cantidades.set(simulacion.charAt(i) - aux, cantidades.get(simulacion.charAt(i) - aux) + 1);

		return cantidades;
	}
	
	public double[][] matrizApariciones(String simulacion, int cantidadSimbolos){
		double[][] matriz = new double[cantidadSimbolos][cantidadSimbolos];
		
		
		for (int i=0; i<cantidadSimbolos; i++) {
		
			for (int j=0; j<cantidadSimbolos; j++)
				matriz[i][j]=0;
		}		
		
		int columnaActual = simulacion.charAt(0) - 'A';
		int filaActual;
		for (int i=1; i<simulacion.length(); i++) {
			filaActual = simulacion.charAt(i)-'A';
			
			matriz[filaActual][columnaActual] += 1;
			columnaActual = simulacion.charAt(i) - 'A';
		}
		
		return matriz;
	}
	
	public double[][] matrizTransicion(double[][] matrizApariciones) {
		int cantidadSimbolos = matrizApariciones.length;
		double[] total = new double[cantidadSimbolos];
		double[][] matAux = new double[cantidadSimbolos][cantidadSimbolos];
		
		for (int i=0; i<cantidadSimbolos; i++) 
			for (int j=0; j<cantidadSimbolos; j++)
				matAux[i][j]=matrizApariciones[i][j];
		
		for (int i=0; i<cantidadSimbolos; i++) 
			total[i] = 0;
		
		for (int i=0; i<cantidadSimbolos; i++) {
			for (int j=0; j<cantidadSimbolos; j++) {
				total[j]+=matrizApariciones[i][j];
			}
		}
		
		for (int i=0; i<cantidadSimbolos; i++)
			for (int j=0; j<cantidadSimbolos; j++)
				matAux[i][j]/=total[j];

		return matAux;
	}
}
