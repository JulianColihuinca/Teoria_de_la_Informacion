package back.domain.calculadoras;

import java.util.ArrayList;
import java.util.Comparator;

public class CalculadoraCodigosInstantaneos {

	//Metodo que genera un codigo instantaneo a partir de probabilidades
	public ArrayList<String> invoke(ArrayList<Double> probabilidades) {
		ArrayList<Double> listaAux = new ArrayList<Double>();
		ArrayList<String> codAux = new ArrayList<String>();
		ArrayList<String> codigos = new ArrayList<String>();

		listaAux.addAll(probabilidades);
		listaAux.sort(Comparator.reverseOrder());

		String codigo = "0";

		for (Double probabilidad : probabilidades) {
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
