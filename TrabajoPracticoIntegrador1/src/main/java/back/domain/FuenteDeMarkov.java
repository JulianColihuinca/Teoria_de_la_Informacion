package back.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Clase que representa una fuente de markov
 */
public class FuenteDeMarkov {

    private double matrizProbabilidades[][];
    private double matrizInformacion[][];
    private double vectorEstacionario[];
    private double vectorPrimeraSumatoria[];
    private double entropia;
    private int cantFuentes = 0;

    public FuenteDeMarkov(String direccion, int cantidadIteraciones) {
        setMatriz(direccion);
        generaMatrizDeInformacion();
        calculaVectorEstacionario(cantidadIteraciones);
        calculaEntropia();
    }

    public int getCantFuentes() {
        return cantFuentes;
    }

    /**
     * Lee de un archivo la dimensi�n y la matriz de transici�n de estados. <br>
     *
     * @param direccion de tipo String: Representa la direcci�n donde se encuentra
     *                  el archivo.
     */
    private void setMatriz(String direccion) {
        try {
            Scanner sc = new Scanner(new File(direccion));
            this.cantFuentes = Integer.parseInt(sc.nextLine());
            matrizProbabilidades = new double[this.cantFuentes][this.cantFuentes];
            int filaActual = 0;
            int columnaActual = 0;
            while (sc.hasNext()) {
                matrizProbabilidades[filaActual][columnaActual++] = Double.parseDouble(sc.next());
                if (columnaActual >= 3) {
                    columnaActual = 0;
                    filaActual++;
                }

            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra la matriz de transici�n de estados
     */
    public void muestraMatrizDeTransicionDeEstados() {
        DecimalFormat formato = new DecimalFormat("#0.000000");
        System.out.println("Matriz P(j/i)");
        for (int i = 0; i < this.cantFuentes; i++) {
            for (int j = 0; j < this.cantFuentes; j++) {
                System.out.print(formato.format(this.matrizProbabilidades[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Genera la matriz I(j/i), la cual es necesaria para el c�lculo de la entrop�a.
     */
    private void generaMatrizDeInformacion() {
        this.matrizInformacion = new double[this.cantFuentes][this.cantFuentes];

        for (int i = 0; i < this.cantFuentes; i++) {
            for (int j = 0; j < this.cantFuentes; j++) {
                this.matrizInformacion[i][j] = -Math.log(this.matrizProbabilidades[i][j]) / Math.log(2);
            }
        }
    }

    /**
     * Muestra la matriz I(j/i)
     */
    public void muestraMatrizDeInformacion() {
        DecimalFormat formato = new DecimalFormat("#0.000000");
        System.out.println("Matriz I(j/i)");
        for (int i = 0; i < this.cantFuentes; i++) {
            for (int j = 0; j < this.cantFuentes; j++) {
                System.out.print(formato.format(this.matrizInformacion[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Calcula la entrop�a H(S) de la fuente
     */
    private void calculaEntropia() {
        // Sumatoria P(j/i)*I(j/i)
        double acumulador;
        this.vectorPrimeraSumatoria = new double[this.cantFuentes];
        for (int k = 0; k < this.cantFuentes; k++) { // me muevo por el vector y filas de las matrices
            acumulador = 0;
            for (int j = 0; j < this.cantFuentes; j++) {// me muevo por columnas de las matrices
                acumulador += this.matrizProbabilidades[k][j] * this.matrizInformacion[k][j];
            }
            this.vectorPrimeraSumatoria[k] = acumulador;
        }

        // Calculo entropia

        this.entropia = 0;
        for (int i = 0; i < this.cantFuentes; i++) {
            this.entropia += this.vectorPrimeraSumatoria[i] * this.vectorEstacionario[i];
        }
    }

    /**
     * Muestra el vector resultante de la sumatoria de los P(j/i) con los I(j/i)
     */
    public void muestraVectorPrimeraSumatoria() {
        DecimalFormat formato = new DecimalFormat("#0.000000");
        System.out.println("Sumatoria P(j/i)*I(j/i)");
        for (int i = 0; i < this.cantFuentes; i++) {
            System.out.println(formato.format(this.vectorPrimeraSumatoria[i]));
        }
        System.out.println();
    }

    /**
     * M�todo que copia una matriz en otra<br>
     *
     * @param mat1 de tipo Double[][]: Representa la matriz a la que ser�n copiados
     *             los datos<br>
     * @param mat2 de tipo Double[][]: Representa la matriz de la que ser�n copiados
     *             los datos.
     */
    private void copiaMatriz(double mat1[][], double mat2[][]) {
        for (int i = 0; i < this.cantFuentes; i++) {
            for (int j = 0; j < this.cantFuentes; j++) {
                mat1[i][j] = mat2[i][j];
            }
        }
    }

    /**
     * M�todo que multiplica dos matrices y almacena el resultado en el primer
     * par�metro.<br>
     *
     * @param mat1 de tipo Double[][]: Representa una de las matrices a multiplicar,
     *             y tambi�n en la que se almacenar�n los datos.<br>
     * @param mat2 de tipo Double[][]: Representa una de las matrices a multiplicar.
     */
    private void multiplicarMatrices(double mat1[][], double mat2[][]) {
        double matAux[][] = new double[this.cantFuentes][this.cantFuentes];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat2.length; j++) {
                matAux[i][j] = 0;
                for (int k = 0; k < mat1[0].length; k++) {
                    matAux[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        copiaMatriz(mat1, matAux);
    }

    /**
     * Calcula el vector estacionario de la matriz de transici�n de estados<br>
     *
     * @param cantidadIteraciones de tipo int: Representa la cantidad de iteraciones
     *                            que se utilizan para calcular el vector
     *                            estacionario
     */
    private void calculaVectorEstacionario(int cantidadIteraciones) {
        this.vectorEstacionario = new double[this.cantFuentes];
        double matAux[][] = new double[this.cantFuentes][this.cantFuentes];
        copiaMatriz(matAux, this.matrizProbabilidades);
        for (int i = 0; i < cantidadIteraciones; i++)
            multiplicarMatrices(matAux, this.matrizProbabilidades);
        int i = 0;
        for (int j = 0; j < this.cantFuentes; j++)
            this.vectorEstacionario[j] = matAux[i][j];
    }

    /**
     * Muestra el vector estacionario
     */
    public void muestraVectorEstacionario() {
        DecimalFormat formato = new DecimalFormat("#0.000000");
        System.out.println("Vector estacionario");
        for (int i = 0; i < this.cantFuentes; i++) {
            System.out.println(formato.format(this.vectorEstacionario[i]));
        }
        System.out.println();
    }

    /**
     * Muestra la entrop�a de la fuente.
     */
    public void muestraEntropia() {
        DecimalFormat formato = new DecimalFormat("#0.000000");
        System.out.println("Entropia H(S) = " + formato.format(this.entropia));
    }
}
