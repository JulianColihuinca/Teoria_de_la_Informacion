package back.domain.formatters;

import java.util.ArrayList;

public class FuenteMemoriaNulaResultFormatter {

	public String format(ArrayList<Double> probabilidades, ArrayList<Double> infoIndividual,
			ArrayList<Double> entropiaIndividual, double entropia, String simulacion,
			ArrayList<Double> probabilidadesSimuladas, ArrayList<Integer> aparicionesSimulacion,
			ArrayList<Double> infosSimuladas, ArrayList<Double> entropiasIndividualesSimuladas,
			double entropiaSimulada) {

		return getInfoSimulacion(simulacion, aparicionesSimulacion)
				+ getInfoProbabilidades(probabilidades, probabilidadesSimuladas)
				+ getInformacionIndividual(infoIndividual, infosSimuladas)
				+ getInfoEntropiaIndividual(entropiaIndividual, entropiasIndividualesSimuladas)
				+ getInfoEntropia(entropia, entropiaSimulada);
	}

	private String getInfoSimulacion(String simulacion, ArrayList<Integer> aparicionesSimulacion) {
		char simbolo = 'a';
		String infoSimulacion = "Simulacion realizada para un N=1000 con las probabilidades ingresadas:\n" + simulacion + "\n\n";
		infoSimulacion += "Simbolo | Apariciones en la simulacion\n";
		for (int i = 0; i < aparicionesSimulacion.size(); i++)
			infoSimulacion += "   " + simbolo++ + "           | " + aparicionesSimulacion.get(i) + "\n";
		return infoSimulacion + "\n";
	}

	private String getInfoProbabilidades(ArrayList<Double> probabilidades, ArrayList<Double> probabilidadesSimuladas) {
		String infoProbabilidades = "Simbolos y probabilidades: \nSimbolo | Probabilidad Ingresada | Probabilidad Simulada";
		char simbolo = 'a';
		for (int i = 0; i < probabilidades.size(); i++) {
			infoProbabilidades += "\n   " + simbolo++ + "           | " + String.format("%1.5f", probabilidades.get(i)) + "\t    | "
					+ String.format("%1.5f",probabilidadesSimuladas.get(i));
		}
		return infoProbabilidades + "\n\n";
	}

	private String getInformacionIndividual(ArrayList<Double> informacionesIndividuales,
			ArrayList<Double> infosSimuladas) {
		char simbolo = 'a';
		String infoIndividual = "Información en [binits] que transmite cada simbolo:";
		infoIndividual += "\nSimbolo | Informacion con datos ingresados | Informacion con datos simulados";
		for (int i = 0; i < informacionesIndividuales.size(); i++) {
			infoIndividual += "\n   " + simbolo++ + "           | "
					+ String.format("%1.7f", informacionesIndividuales.get(i)) + " \t                       | "
					+ String.format("%1.7f", infosSimuladas.get(i));
		}
		return infoIndividual + "\n\n";
	}

	private String getInfoEntropiaIndividual(ArrayList<Double> entropiaIndividual,ArrayList<Double> entropiasSimuladas) {
		char simbolo = 'a';
		String infoEntropia = "Entropia de cada simbolo en [binits/simbolo] :";
		infoEntropia += "\nSimbolo | Entropia con datos ingresados | Entropia con datos simulados";
		for (int i = 0; i < entropiaIndividual.size(); i++) {
			infoEntropia += "\n   " + simbolo++ + "           | "
					+ String.format("%1.7f", entropiaIndividual.get(i)) + " \t                 | "
					+ String.format("%1.7f", entropiasSimuladas.get(i));
		}
		return infoEntropia + "\n\n";
	}

	private String getInfoEntropia(double entropia,double entropiaSimulada) {
		String infoEntropia = "Entropia de la fuente en [binits/simbolo] :";
		infoEntropia += "\nCon datos ingresados : H(S)= " + entropia;
		infoEntropia += "\nCon datos simulados  : H(S)= " + entropiaSimulada;
		return infoEntropia + "\n\n";
	}
}
