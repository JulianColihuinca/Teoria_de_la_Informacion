package back.domain.calculadoras;

import java.util.ArrayList;

import back.domain.interfaces.ICalculadoraShannonFano;

public class CalculadoraShannonFano implements ICalculadoraShannonFano {

	@Override
	public void analizarTexto(String cadena, ArrayList<Character> simbolos, ArrayList<Integer> frecuencias,
			ArrayList<Double> probabilidades, ArrayList<String> codigos) {

		int pos;
		Character auxChar;
		int longitud = cadena.length();

		for (int i = 0; i < longitud; i++) {
			pos = 0;
			auxChar = cadena.charAt(i);
			int indice = simbolos.indexOf(auxChar);
			if (indice!=-1) {
				frecuencias.set(indice, frecuencias.get(indice)+1);
			}
			else {
				frecuencias.add(1);
				simbolos.add(auxChar);
			}
		}

		for (int i = 0; i < simbolos.size(); i++)
			probabilidades.add(frecuencias.get(i) / (double) longitud);

		ordenaDecreciente(simbolos, frecuencias, probabilidades);
		generaCodigos(simbolos, probabilidades, simbolos.size(), codigos);

	}

	@Override
	public double calculaEntropia(ArrayList<Double> probabilidades) {
		ArrayList<Double> infos = new ArrayList<>();
		ArrayList<Double> entropias = new ArrayList<>();
		
        for (Double x: probabilidades) {
        	if (x!=0)
        		infos.add(Math.abs(-Math.log(x)/Math.log(2)));
        	else
        		infos.add(0.0);
        }
        for (int i=0;i<probabilidades.size();i++) {
            entropias.add(probabilidades.get(i) * infos.get(i));
        }
        return entropias.stream().mapToDouble(x -> x).sum();
	}
	
	@Override
	public double calculaLongitudMedia(ArrayList<String> codigos, ArrayList<Double> probabilidades) {
		ArrayList<Integer> longitudes = new ArrayList<Integer>();
		double acum = 0;
		
		for (int i=0; i<codigos.size();i++) {
			longitudes.add(codigos.get(i).length());
		}		
		for (int i = 0; i < probabilidades.size(); i++) {
			acum += probabilidades.get(i) * longitudes.get(i);
		}
		
		return acum;
	}
	
	@Override
	public int tasaDeCompresionEntera(String textoIngresado, ArrayList<Character> simbolos, ArrayList<Integer> frecuencias,
			ArrayList<String> codigos) {
		int acum=0;
		for (int i=0; i<simbolos.size(); i++) {
			acum += frecuencias.get(i) * codigos.get(i).length();
		}
		return (int) ((double)textoIngresado.length()*8/(double)acum);
	}
	
	@Override
	public double tasaDeCompresion(String textoIngresado, ArrayList<Character> simbolos, ArrayList<Integer> frecuencias,
			ArrayList<String> codigos) {
		int acum=0;
		for (int i=0; i<simbolos.size(); i++) {
			acum += frecuencias.get(i) * codigos.get(i).length();
		}
		return ((double)textoIngresado.length()*8/(double)acum);
	}
	
	private void generaCodigos(ArrayList<Character> simbolos, ArrayList<Double> probabilidades, int n,
			ArrayList<String> codigos) {

		for (int i = 0; i < simbolos.size(); i++) {
			codigos.add("");
		}

		proceso(probabilidades, codigos, probabilidades.size(), 0);
	}
	
	private void ordenaDecreciente(ArrayList<Character> simbolos, ArrayList<Integer> frecuencias,
			ArrayList<Double> probabilidades) {
		Double auxP;
		Integer auxF;
		Character auxS;
		for (int i = 0; i < simbolos.size() - 1; i++) {
			for (int j = 0; j < simbolos.size() - i - 1; j++) {
				if (probabilidades.get(j) < probabilidades.get(j + 1)) {
					auxP = probabilidades.get(j);
					probabilidades.set(j, probabilidades.get(j + 1));
					probabilidades.set(j + 1, auxP);
					auxF = frecuencias.get(j);
					frecuencias.set(j, frecuencias.get(j + 1));
					frecuencias.set(j + 1, auxF);
					auxS = simbolos.get(j);
					simbolos.set(j, simbolos.get(j + 1));
					simbolos.set(j + 1, auxS);
				}
			}
		}
	}

	private void proceso(ArrayList<Double> probs, ArrayList<String> codigos, int n, int posInicio) {
		ArrayList<Double> probs1 = new ArrayList<Double>();
		ArrayList<Double> probs2 = new ArrayList<Double>();
		int puntoMedio = puntoMedio(probs, n);
		
		for (int i = 0; i < puntoMedio; i++) {
			probs1.add(probs.get(i));
			codigos.set(posInicio + i, codigos.get(posInicio + i) + "1");
		}

		for (int i = puntoMedio; i < n; i++) {
			probs2.add(probs.get(i));
			codigos.set(posInicio + i, codigos.get(posInicio + i) + "0");
		}

		if (probs1.size() > 1)
			proceso(probs1, codigos, probs1.size(), posInicio);
		if (probs2.size() > 1)
			proceso(probs2, codigos, probs2.size(), posInicio + puntoMedio);
		return;
	}

	private int puntoMedio(ArrayList<Double> probabilidades, int n) {

		int medio;
		double primeraSuma, segundaSuma, resultadoAnterior;

		primeraSuma = probabilidades.get(0);
		segundaSuma = 0;
		for (int i = 1; i < n; i++)
			segundaSuma += probabilidades.get(i);
		medio = 1;
		
		do {
			medio++;
			resultadoAnterior = Math.abs(primeraSuma - segundaSuma);
			primeraSuma = 0;
			segundaSuma = 0;
			for (int i = 0; i < medio; i++)
				primeraSuma += probabilidades.get(i);
			for (int j = medio; j < n; j++)
				segundaSuma += probabilidades.get(j);
		} while (Math.abs(primeraSuma - segundaSuma) <= resultadoAnterior);
		
		return (int) Math.ceil(medio - 1);
	}
	
	
	
	
}
