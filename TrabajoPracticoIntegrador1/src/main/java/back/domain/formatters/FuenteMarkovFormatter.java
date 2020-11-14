package back.domain.formatters;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class FuenteMarkovFormatter {
    public String format(double[][] matrizProbabilidades, double[][] matrizInformacion,
                         double[] vectorEstacionario, double entropia,
                         String simulacion, ArrayList<Integer> aparicionesSimulacion,
                         double[][] probabilidadesSimuladas) {
        return getInfoSimulacion(simulacion,aparicionesSimulacion)
                + getInfoMatrizDeTransicionDeEstados(matrizProbabilidades)
                + getInfoMatrizDeTransicionDeEstados(probabilidadesSimuladas)
                + getInfoMatrizDeInformacion(matrizInformacion)
                + getInfoVectorEstacionario(vectorEstacionario)
                + getInfoEntropia(entropia);
    }

    private String getInfoSimulacion(String simulacion, ArrayList<Integer> aparicionesSimulacion) {
		char simbolo = 'a';
		String infoSimulacion = "Simulacion realizada para un N=1000 con las probabilidades ingresadas:\n" + simulacion + "\n\n";
		infoSimulacion += "Simbolo | Apariciones en la simulacion\n";
		for (int i = 0; i < aparicionesSimulacion.size(); i++)
			infoSimulacion += "   " + simbolo++ + "           | " + aparicionesSimulacion.get(i) + "\n";
		return infoSimulacion + "\n";
	}

    private String getInfoMatrizDeTransicionDeEstados(double[][] matrizProbabilidades) {
        DecimalFormat formato = new DecimalFormat("#0.000000");
        String matrizTransEstados = "Matriz de transicion de estados con datos ingresados\n";
        for (int i = 0; i < matrizProbabilidades.length; i++) {
            for (int j = 0; j < matrizProbabilidades.length; j++) {
                matrizTransEstados += formato.format(matrizProbabilidades[i][j]) + " ";
            }
            matrizTransEstados += "\n";
        }
        return matrizTransEstados + "\n";
    }

    private String getInfoMatrizDeInformacion(double[][] matrizInformacion) {
        DecimalFormat formato = new DecimalFormat("#0.000000");
        String matrizInfo = "Matriz I(j/i)\n";
        for (int i = 0; i < matrizInformacion.length; i++) {
            for (int j = 0; j < matrizInformacion.length; j++) {
                matrizInfo += formato.format(matrizInformacion[i][j]) + " ";
            }
            matrizInfo += "\n";
        }
        return matrizInfo + "\n";
    }

    private String getInfoVectorEstacionario(double[] vectorEstacionario) {
        DecimalFormat formato = new DecimalFormat("#0.000000");
        String resultado = "Vector estacionario\n";
        for (int i = 0; i < vectorEstacionario.length; i++) {
            resultado += formato.format(vectorEstacionario[i]) + "\n";
        }
        return resultado + "\n";
    }

    private String getInfoEntropia(double entropia) {
        DecimalFormat formato = new DecimalFormat("#0.000000");
        return "\nEntropia H(S) = " + formato.format(entropia) + " binits/simbolo";
    }
}
