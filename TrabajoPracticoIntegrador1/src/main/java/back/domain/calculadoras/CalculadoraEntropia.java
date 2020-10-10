package back.domain.calculadoras;

import java.util.ArrayList;

public class CalculadoraEntropia {
    public double calculaEntropia(ArrayList<Double> entropiaIndividual) {
        return entropiaIndividual.stream().mapToDouble(x -> x).sum();
    }

    public ArrayList<Double> calculaEntropiaIndividual(ArrayList<Double> probabilidades, ArrayList<Double> infoIndividual) {
        ArrayList<Double> entropiaIndividual = new ArrayList<>();
        for (int i=0;i<probabilidades.size();i++) {
            entropiaIndividual.add(probabilidades.get(i) * infoIndividual.get(i));
        }
        return entropiaIndividual;
    }

    public double calculaEntropia(double[][] matrizProbabilidades, double[][] matrizInformacion, double[] vectorEstacionario) {
        // Sumatoria P(j/i)*I(j/i)
        double entropia = 0;
        double[] vectorPrimeraSumatoria = calculaVectorPrimeraSumatoria(matrizProbabilidades, matrizInformacion);
        for (int i = 0; i < matrizProbabilidades.length; i++) {
            entropia += vectorPrimeraSumatoria[i] * vectorEstacionario[i];
        }
        return entropia;
    }

    private double[] calculaVectorPrimeraSumatoria(double[][] matrizProbabilidades, double[][] matrizInformacion) {
        int cantFilas = matrizProbabilidades.length;
        double acumulador;
        double[] vectorPrimeraSumatoria = new double[cantFilas];
        for (int k = 0; k < cantFilas; k++) { // me muevo por el vector y filas de las matrices
            acumulador = 0;
            for (int j = 0; j < cantFilas; j++) {// me muevo por columnas de las matrices
                acumulador += matrizProbabilidades[k][j] * matrizInformacion[k][j];
            }
            vectorPrimeraSumatoria[k] = acumulador;
        }
        return vectorPrimeraSumatoria;
    }
}
