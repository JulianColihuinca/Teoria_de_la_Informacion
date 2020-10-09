package back.domain.calculadoras;

import java.util.ArrayList;

public class CalculadoraCantInformacion {
    public ArrayList<Double> invoke(ArrayList<Double> probabilidades) {
        ArrayList<Double> infoIndividuales = new ArrayList<>();
        for (Double x: probabilidades) {
            infoIndividuales.add(-Math.log(x)/Math.log(2));
        }
        return infoIndividuales;
    }

    /* Nuevo metodo que creo que deberia ir en una nueva calculadora llamandose invoke, se calcula la matriz de informacion */
    public double[][] calcula(double matrizProbabilidades[][],int dimension){
        double matrizInformacion[][] = new double[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (matrizProbabilidades[i][j]!=0)
                    matrizInformacion[i][j] =Math.abs(-Math.log(matrizProbabilidades[i][j]) / Math.log(2));
                else
                    matrizInformacion[i][j]=0;
            }
        }
        return matrizInformacion;
    }
}
