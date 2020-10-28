package back.domain.calculadoras;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CalculadoraLongitudCodigos {

	//Metodo que calcula longitudes individuales
	public ArrayList<Integer> invoke(ArrayList<String> codigos) {
		return new ArrayList<>(codigos.stream().map(codigo -> codigo.length()).collect(Collectors.toList()));
	}
	
	//Metodo que calcula longitud media
	public double invoke(ArrayList<Integer> longitudes, ArrayList<Double> probabilidades) {
		double acum = 0;
		for (int i = 0; i < probabilidades.size(); i++) {
			acum += probabilidades.get(i) * longitudes.get(i);
		}
		return acum;
	}
}
