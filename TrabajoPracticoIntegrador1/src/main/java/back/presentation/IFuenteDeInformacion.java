package back.presentation;

import java.util.ArrayList;

public interface IFuenteDeInformacion {
    String calcularEntropiaFuenteMemNula(String nombreArchivo);
    String calcularEntropiaFuenteMemNula(ArrayList<Double> probabilidades);

    String calcularMatrizEntropiaFuenteMarkov(String nombreArchivo);
    String calcularMatrizEntropiaFuenteMarkov(double[][] matrizProbabilidades);

    String calcularCodigosInstantaneos(ArrayList<Double> probabilidades);

    String calcularCodigosInstantaneos(String nombreArchivo);
}
