package back.domain.calculadoras;

import java.util.ArrayList;
import java.util.Collections;

public class CalculadoraCodigosInstantaneos {
	
	//Si se puede, mejorar el código
	//Metodo que genera un codigo instantaneo a partir de probabilidades
	public ArrayList<String> invoke(ArrayList<Double> probabilidades) {
		ArrayList<Double> listaAux = new ArrayList<Double>();
		ArrayList<String> codAux = new ArrayList<String>();
		ArrayList<String> codigos = new ArrayList<String>();

		for (Double x : probabilidades) {
			listaAux.add(x);
		}
		Collections.sort(listaAux);
		Collections.reverse(listaAux);

		String codigo = "0";
		for (int i = 0; i < probabilidades.size(); i++) {
			codAux.add(codigo);
			codigo = "1" + codigo;
		}

		int i, j = 0;
		while (!listaAux.isEmpty()) {
			i = 0;
			while (probabilidades.get(j) != listaAux.get(i))
				i++;
			codigos.add(codAux.get(i));
			codAux.remove(i);
			listaAux.remove(i);
			j++;
		}
		return codigos;
	}
}
