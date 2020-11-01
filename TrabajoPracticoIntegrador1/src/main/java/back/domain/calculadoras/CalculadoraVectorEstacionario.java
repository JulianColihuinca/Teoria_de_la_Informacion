package back.domain.calculadoras;

public class CalculadoraVectorEstacionario {
    private final int cantidadIteraciones = 20;

    public double[] invoke(double[][] matrizProbabilidades) {
        int cantFilas = matrizProbabilidades.length;
        double[] vectorEstacionario = new double[cantFilas];
        double matAux[][] = new double[cantFilas][cantFilas];

        copiaMatriz(matAux, matrizProbabilidades, cantFilas);

        for (int i = 0; i < cantidadIteraciones; i++)
            multiplicarMatrices(matAux, matrizProbabilidades, cantFilas);

        int j = 0;

        for (int i = 0; i < cantFilas; i++)
            vectorEstacionario[i] = matAux[i][j];

        return vectorEstacionario;
    }

    private void multiplicarMatrices(double mat1[][], double mat2[][], int cantFilas) {
        double matAux[][] = new double[cantFilas][cantFilas];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat2.length; j++) {
                matAux[i][j] = 0;
                for (int k = 0; k < mat1[0].length; k++) {
                    matAux[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        copiaMatriz(mat1, matAux, cantFilas);
    }

    private void copiaMatriz(double mat1[][], double mat2[][], int cantFilas) {
        for (int i = 0; i < cantFilas; i++) {
            for (int j = 0; j < cantFilas; j++) {
                mat1[i][j] = mat2[i][j];
            }
        }
    }
}
