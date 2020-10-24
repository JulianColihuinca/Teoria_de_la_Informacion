package back.domain.calculadoras;

import java.util.ArrayList;

public class CalculadoraPropiedades {

	//Metodo que comprueba que se cumpla la propiedad de kraft
	public String invoke(ArrayList<Integer> longitudes) {
		String cadena;
		double acum = 0;
		for (Integer x : longitudes) {
			acum += Math.pow(2, -x);
		}
		if (acum <= 1)
			cadena = "Cumple la inecuación de Kraft ya que la sumatoria r^(-li) con r=2 es " + acum
					+ " y se cumple que " + acum + " <= 1";
		else
			cadena = "No cumple la inecuación de Kraft ya que la sumatoria r^(-li) con r=2 es " + acum
					+ " y no se cumple que " + acum + " <= 1";
		return cadena;
	}
	
	//Metodo que comprueba que el codigo sea compacto
	public String invoke(ArrayList<Double> informaciones, ArrayList<Integer> longitudes) {
		int i=0;
		String cadena;
		while (Math.ceil(informaciones.get(i))>longitudes.get(0) && i<informaciones.size())
			i++;
		if (i<informaciones.size())
			cadena = "La longitud del codigo "+i+" es mayor que su informacion y no cumple la propiedad de codigo compacto según la desigualdad de Kraft";
		else
			cadena = "Se cumple la propiedad de codigo compacto según la desigualdad de Kraft";
		return cadena;
	}
}
