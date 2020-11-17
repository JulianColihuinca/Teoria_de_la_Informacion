package back.domain.calculadoras;

import java.util.ArrayList;

public class CalculadoraPropiedades {

	// Metodo que comprueba que se cumpla la propiedad de kraft
	public String invoke(ArrayList<Integer> longitudes) {
		String cadena;
		double acum = 0;
		for (Integer x : longitudes) {
			acum += Math.pow(2, -x);
		}
		if (acum <= 1)
			cadena = "Cumple la inecuaci�n de Kraft ya que la sumatoria r^(-li) con r=2 es " + acum
					+ " y se cumple que " + acum + " <= 1";
		else
			cadena = "No cumple la inecuaci�n de Kraft ya que la sumatoria r^(-li) con r=2 es " + acum
					+ " y no se cumple que " + acum + " <= 1";
		return cadena;
	}

	// Metodo que comprueba que el codigo sea compacto
	public String invoke(ArrayList<Double> informaciones, ArrayList<Integer> longitudes) {
		int i = 0;
		String cadena;
		while (i < informaciones.size() && Math.ceil(informaciones.get(i)) >= longitudes.get(i))
			i++;
		if (i < informaciones.size())
			cadena = "La longitud del codigo " + (i + 1)
					+ " es mayor que su informacion y no cumple la propiedad de codigo compacto seg�n Kraft";
		else
			cadena = "Se cumple la propiedad de codigo compacto seg�n la deducci�n que parte de la desigualdad de Kraft,\ndonde todas las longitudes se encuentran en el rango de I(Si)real <= L(Si) <= I(Si) redondeado hacia arriba";
		return cadena;
	}
}
