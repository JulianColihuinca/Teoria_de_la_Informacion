package back.domain.calculadoras;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculadoraDeSimulacionFuenteNulaConCodigos {

	// Genera la secuencia de simbolos con las probabilidades administradas por la
	// cátedra
	public String simulaSimbolos(ArrayList<Double> probabilidades, int cantidad) {
		int cantidadDeProbabilidades = probabilidades.size();
		String secuencia = "";
		double random, acumulador;
		int posicion;
		String simbolo;
		char auxSimbolo;
		for (int i = 0; i < cantidad; i++) {
			posicion = 0;
			simbolo="S";
			auxSimbolo='1';
			acumulador = probabilidades.get(0);
			random = Math.random();
			while (posicion < cantidadDeProbabilidades && acumulador < random) {
				posicion++;
				acumulador += probabilidades.get(posicion);
			}
			auxSimbolo+=posicion;
			simbolo+=auxSimbolo;
			secuencia += simbolo;
		}
		return secuencia;
	}	
	
	//Metodo que simula una secuencia de codigos a partir de la simulacion realizada de simbolos
	public String simulaCodigos(String simulacionSimbolos, ArrayList<String> codigos) {
		//49 = caracter 1 en tabla ascii
		String simulacion="";
		char aux;
		for (int i=1; i<simulacionSimbolos.length(); i+=2) {
			aux = simulacionSimbolos.charAt(i);
			simulacion+= codigos.get(aux-49);
		}
		return simulacion;
	}
	
	//Metodo que cuenta la cantidad de apariciones de cada simbolo en la simulacion realizada
	public ArrayList<Integer> cuentaApariciones(String simulacion,int cantidadDeSimbolos){
		ArrayList<Integer> apariciones = new ArrayList<Integer>();
		String codigoBuscado;
		char aux='1';
		for (int i=0; i<cantidadDeSimbolos; i++) {
			codigoBuscado="S";
			codigoBuscado+= aux++;
			apariciones.add(cuentaOcurrencias(codigoBuscado,simulacion));
		}		
		return apariciones;
	}
	
	
	//Metodo que cuenta ocurrencias de una cadena en otra
	private int cuentaOcurrencias(String buscada, String simulacion) {
		Pattern patron = Pattern.compile(buscada);
		Matcher match = patron.matcher(simulacion);
		
		int ocurrencias = 0;
	    while (match.find()) {
	      ocurrencias++;
	    }
	    return ocurrencias;
	}
	
	public ArrayList<Double> calculaProbabilidades(ArrayList<Integer> apariciones, int cantidadTotal){
		ArrayList<Double> probs = new ArrayList<Double>();
		for (int i=0; i<apariciones.size(); i++)
			probs.add((double) apariciones.get(i)/cantidadTotal);
		return probs;
	}
}
