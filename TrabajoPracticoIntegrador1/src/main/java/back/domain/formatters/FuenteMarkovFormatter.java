package back.domain.formatters;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class FuenteMarkovFormatter {
	public String format(double[][] matrizProbabilidades, double[][] matrizInformacion, double[] vectorEstacionario,
			double entropia, String simulacion, ArrayList<Integer> aparicionesSimulacion,
			double[][] matrizTransicionSimulada, double[][] matrizInformacionSimulada,
			double[] vectorEstacionarioSimulado, double entropiaSimulada, double[][] matrizApariciones,
			int cantidadDeIteraciones) {
		return getInfoSimulacion(simulacion, aparicionesSimulacion, matrizApariciones,cantidadDeIteraciones)
				+ getInfoMatrizDeTransicionDeEstados(matrizProbabilidades, matrizTransicionSimulada)
				+ getInfoMatrizDeInformacion(matrizInformacion, matrizInformacionSimulada)
				+ getInfoVectorEstacionario(vectorEstacionario, vectorEstacionarioSimulado)
				+ getInfoEntropia(entropia, entropiaSimulada);
	}

	private String getInfoSimulacion(String simulacion, ArrayList<Integer> aparicionesSimulacion,
			double[][] matrizApariciones,int iteraciones) {
		char simbolo = 'A';
		DecimalFormat formato = new DecimalFormat("#0000");
		String infoSimulacion = "Simulacion realizada para un N="+iteraciones+" con las probabilidades ingresadas:\n" + simulacion
				+ "\nAclaracion: Se generan "+(iteraciones+1)+" simbolos, siendo el primero generado aleatoriamente, pero no contado, para comenzar los calculos de una matriz de transicion\n\n";
		infoSimulacion += "Simbolo | Apariciones en la simulacion\n";
		for (int i = 0; i < aparicionesSimulacion.size(); i++)
			infoSimulacion += "   " + simbolo++ + "           | " + aparicionesSimulacion.get(i) + "\n";
		infoSimulacion += "\nMatriz de apariciones en la simulacion\n";
		for (int i = 0; i < matrizApariciones.length; i++) {
			infoSimulacion += " | ";
			for (int j = 0; j < matrizApariciones.length; j++) {
				infoSimulacion += formato.format(matrizApariciones[i][j]) + " | ";
			}
			infoSimulacion += "\n";
		}
		return infoSimulacion + "\n";
	}

	private String getInfoMatrizDeTransicionDeEstados(double[][] matrizProbabilidades, double[][] matrizSimulada) {
		DecimalFormat formato = new DecimalFormat("#0.000000");
		String matrizTransEstados = "Matriz de transicion de estados con datos ingresados\n";
		for (int i = 0; i < matrizProbabilidades.length; i++) {
			matrizTransEstados += " | ";
			for (int j = 0; j < matrizProbabilidades.length; j++) {
				matrizTransEstados += formato.format(matrizProbabilidades[i][j]) + " | ";
			}
			matrizTransEstados += "\n";
		}
		matrizTransEstados += "----------------------\n";
		matrizTransEstados += "Matriz de transicion de estados con datos simulados\n";
		for (int i = 0; i < matrizSimulada.length; i++) {
			matrizTransEstados += " | ";
			for (int j = 0; j < matrizSimulada.length; j++) {
				matrizTransEstados += formato.format(matrizSimulada[i][j]) + " | ";
			}
			matrizTransEstados += "\n";
		}
		return matrizTransEstados + "\n\n";
	}

	private String getInfoMatrizDeInformacion(double[][] matrizInformacion, double[][] matrizInformacionSimulada) {
		DecimalFormat formato = new DecimalFormat("#0.000000");
		String matrizInfo = "Matriz de informacion en [binits] con datos ingresados\n";
		for (int i = 0; i < matrizInformacion.length; i++) {
			matrizInfo += " | ";
			for (int j = 0; j < matrizInformacion.length; j++) {
				matrizInfo += formato.format(matrizInformacion[i][j]) + " | ";
			}
			matrizInfo += "\n";
		}
		matrizInfo += "----------------------\n";
		matrizInfo += "Matriz de informacion en [binits] con datos simulados\n";
		for (int i = 0; i < matrizInformacionSimulada.length; i++) {
			matrizInfo += " | ";
			for (int j = 0; j < matrizInformacionSimulada.length; j++) {
				matrizInfo += formato.format(matrizInformacionSimulada[i][j]) + " | ";
			}
			matrizInfo += "\n";
		}
		return matrizInfo + "\n\n";
	}

	private String getInfoVectorEstacionario(double[] vectorEstacionario, double[] vectorEstacionarioSimulado) {
		DecimalFormat formato = new DecimalFormat("#0.000000");
		String resultado = "Vector estacionario calculado con datos ingresados\n";
		for (int i = 0; i < vectorEstacionario.length; i++) {
			resultado += formato.format(vectorEstacionario[i]) + "\n";
		}
		resultado += "----------------------\n";
		resultado += "Vector estacionario calculado con datos simulados\n";
		for (int i = 0; i < vectorEstacionarioSimulado.length; i++) {
			resultado += formato.format(vectorEstacionarioSimulado[i]) + "\n";
		}
		return resultado + "\n";
	}

	private String getInfoEntropia(double entropia, double entropiaSimulada) {
		DecimalFormat formato = new DecimalFormat("#0.000000");
		String infoEntropia = "Entropia calculada con datos ingresados H(S) = " + formato.format(entropia)
				+ " [binits/simbolo]\n";
		infoEntropia += "Entropia calculada con datos simulados H(S) = " + formato.format(entropiaSimulada)
				+ " [binits/simbolo]\n";
		return infoEntropia;
	}
}
