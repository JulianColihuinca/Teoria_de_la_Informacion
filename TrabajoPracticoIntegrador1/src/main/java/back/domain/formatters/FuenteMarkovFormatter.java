package back.domain.formatters;

import java.text.DecimalFormat;

public class FuenteMarkovFormatter {
    public String format(double[][] matrizProbabilidades, double[][] matrizInformacion,
                         double[] vectorEstacionario, double entropia) {
        return getInfoMatrizDeTransicionDeEstados(matrizProbabilidades) + getInfoMatrizDeInformacion(matrizInformacion) +
                getInfoVectorEstacionario(vectorEstacionario) + getInfoEntropia(entropia);
    }

    private String getInfoMatrizDeTransicionDeEstados(double[][] matrizProbabilidades) {
        DecimalFormat formato = new DecimalFormat("#0.000000");
        String matrizTransEstados = "Matriz P(j/i)\n";
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
        return "\nEntropia H(S) = " + formato.format(entropia);
    }
}
