package back.domain.calculadoras;

public class CalculadoraMatrizInformacion {
    public double[][] invoke(double matrizProbabilidades[][]){
        int cantFilas = matrizProbabilidades.length;
        double matrizInformacion[][] = new double[cantFilas][cantFilas];

        for (int i = 0; i < cantFilas; i++) {
            for (int j = 0; j < cantFilas; j++) {
                if (matrizProbabilidades[i][j]!=0)
                    matrizInformacion[i][j] =Math.abs(-Math.log(matrizProbabilidades[i][j]) / Math.log(2));
                else
                    matrizInformacion[i][j]=0;
            }
        }
        return matrizInformacion;
    }
}
