package back.domain.interfaces;

import java.util.ArrayList;

public interface ICalculadoraShannonFano {

	void analizarTexto(String cadena, ArrayList<Character> simbolos, ArrayList<Integer> frecuencias,
			ArrayList<Double> probabilidades, ArrayList<String> codigos);

	double calculaEntropia(ArrayList<Double> probabilidades);

	double calculaLongitudMedia(ArrayList<String> codigos, ArrayList<Double> probabilidades);

	int tasaDeCompresionEntera(String textoIngresado, ArrayList<Character> simbolos, ArrayList<Integer> frecuencias,
			ArrayList<String> codigos);
	
	double tasaDeCompresion(String textoIngresado, ArrayList<Character> simbolos, ArrayList<Integer> frecuencias,
			ArrayList<String> codigos);
}
