package back.domain.formatters;

import java.util.ArrayList;

public class CodigosInstantaneosFormatter {

	public String format(ArrayList<String> codigos, ArrayList<Double> probabilidades, ArrayList<Double> infoIndividual,
			ArrayList<Double> entropiaIndividual, double entropia, ArrayList<Integer> longitudesIndividuales,
			double longitudMedia, String kraft, String compacto, String simulacionSimbolos, String simulacionCodigos,
			ArrayList<Integer> aparicionesSimulacion, ArrayList<Double> probabilidadesSimuladas,
			ArrayList<Double> infosIndividualesSimuladas, ArrayList<Double> entropiasIndividualesSimuladas,
			double entropiaSimulada, double longitudMediaSimulada, String compactoSimulado) {
		return getInfoProbabilidadesYCodigos(probabilidades, codigos)
				+ getInfoSimulacion(simulacionSimbolos, simulacionCodigos, aparicionesSimulacion, codigos)
				+ getInfoCodigoBloqueSimulado(probabilidadesSimuladas, codigos)
				+ getInformacionIndividual(infoIndividual, infosIndividualesSimuladas)
				+ getInfoEntropiaIndividual(entropiaIndividual, entropiasIndividualesSimuladas)
				+ getInfoEntropia(entropia, entropiaSimulada)
				+ getInfoLongitudes(longitudesIndividuales, longitudMedia, longitudMediaSimulada) + getInfoKraft(kraft)
				+ getInfoCompacto(compacto, compactoSimulado);
	}

	private String getInfoProbabilidadesYCodigos(ArrayList<Double> probabilidades, ArrayList<String> codigos) {
		String infoBloque = "Codigo Bloque con datos ingresados";
		for (int i = 0; i < probabilidades.size(); i++) {
			infoBloque += "\nP(S" + (i + 1) + ") = " + String.format("%1.5f", probabilidades.get(i)) + " | "
					+ codigos.get(i);
		}

		return infoBloque + "\n\n";
	}

	private String getInfoSimulacion(String simulacionSimbolos, String simulacionCodigos,
			ArrayList<Integer> apariciones, ArrayList<String> codigos) {
		String infoSimulacion = "Codigo generado por una simulacion de N=1000 apariciones:\n";
		infoSimulacion += "Expresado en simbolos: " + simulacionSimbolos + "\n";
		infoSimulacion += "Expresado en codigo: " + simulacionCodigos + "\n\n";
		infoSimulacion += "Codigo -> Cantidad de apariciones en la simulacion\n";
		for (int i = 0; i < apariciones.size(); i++)
			infoSimulacion += codigos.get(i) + " -> " + apariciones.get(i) + "\n";
		return infoSimulacion + "\n";
	}

	private String getInfoCodigoBloqueSimulado(ArrayList<Double> probabilidades, ArrayList<String> codigos) {
		String bloque = "";

		bloque = "Codigo Bloque con datos simulados";
		for (int i = 0; i < probabilidades.size(); i++) {
			bloque += "\nP(S" + (i + 1) + ") = " + String.format("%1.5f", probabilidades.get(i)) + " | "
					+ codigos.get(i);
		}
		return bloque + "\n\n";
	}

	private String getInformacionIndividual(ArrayList<Double> informacionesIndividuales,
			ArrayList<Double> infosIndividualesSimuladas) {
		int i = 0;
		String infoIndividual = "Informacion en [binits] que transmite cada simbolo para los datos ingresados:";
		for (Double x : informacionesIndividuales) {
			infoIndividual += "\nI(S" + ++i + ") real = " + String.format("%1.7f", x) + " | I(S" + i
					+ ") para comprobar compacticidad = " + Math.ceil(x);
		}
		i = 0;
		infoIndividual += "\n----------------\n";
		infoIndividual += "Informacion en [binits] que transmite cada simbolo para los datos simulados:";
		for (Double x : infosIndividualesSimuladas) {
			infoIndividual += "\nI(S" + ++i + ") real = " + String.format("%1.7f", x) + " | I(S" + i
					+ ") para comprobar compacticidad = " + Math.ceil(x);
		}
		return infoIndividual + "\n\n";
	}

	private String getInfoEntropiaIndividual(ArrayList<Double> entropiaIndividual,
			ArrayList<Double> entropiasIndividualesSimuladas) {
		int i = 0;
		String infoEntropia = "Entropia de cada simbolo en [binits/simbolo] para los datos ingresados:";
		for (Double x : entropiaIndividual) {
			infoEntropia += "\nH(S" + ++i + ") = " + String.format("%1.7f", x);
		}
		i = 0;
		infoEntropia += "\n----------------\n";
		infoEntropia += "Entropia de cada simbolo en [binits/simbolo] para los datos simulados:";
		for (Double x : entropiasIndividualesSimuladas) {
			infoEntropia += "\nH(S" + ++i + ") = " + String.format("%1.7f", x);
		}
		return infoEntropia + "\n\n";
	}

	private String getInfoEntropia(double entropia, double entropiaSimulada) {
		String infoEntropia = "Entropia de la fuente en [binits/simbolo]:";
		infoEntropia += "\nCon datos ingresados : H(S)= " + String.format("%1.7f", entropia);
		infoEntropia += "\nCon datos simulados : H(S)= " + String.format("%1.7f", entropiaSimulada);
		return infoEntropia + "\n\n";
	}

	private String getInfoLongitudes(ArrayList<Integer> longitudes, double longitudMedia,
			double longitudMediaSimulada) {
		int i = 0;
		String infoLongitudes = "Longitudes L(Si) de cada codigo generado: ";
		for (Integer x : longitudes) {
			infoLongitudes += "\nL(S" + ++i + ") = " + x;
		}
		infoLongitudes += "\n\nLongitud Media para datos ingresados: " + String.format("%1.7f", longitudMedia);
		infoLongitudes += "\nLongitud Media para datos simulados: " + String.format("%1.7f", longitudMediaSimulada);
		return infoLongitudes + "\n";
	}

	private String getInfoKraft(String kraft) {
		return "\nLa propiedad de kraft depende de la longitud de los codigos, por lo que no cambia aunque si lo haga la simulacion:\n"
				+ kraft + "\n";
	}

	private String getInfoCompacto(String compacto, String compactoSimulado) {
		return "\nCompacticidad para datos ingresados: " + compacto + "\nCompacticidad para datos simulados: "+compactoSimulado;
	}

}
