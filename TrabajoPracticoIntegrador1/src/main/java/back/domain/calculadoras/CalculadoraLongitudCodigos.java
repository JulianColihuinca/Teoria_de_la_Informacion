package back.domain.calculadoras;

import java.util.ArrayList;

public class CalculadoraLongitudCodigos {

	//Metodo que calcula longitudes individuales
	public ArrayList<Integer> invoke(ArrayList<String> codigos) {
		ArrayList<Integer> longitudes = new ArrayList<Integer>();
		for (int i=0; i<codigos.size();i++) {
			longitudes.add(codigos.get(i).length());
		}
		return longitudes;
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
