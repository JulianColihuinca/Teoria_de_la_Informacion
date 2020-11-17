package back.presentation;

import java.util.ArrayList;

public interface IFuenteDeInformacion {
    String calcularEntropiaFuenteMemNula(String nombreArchivo,int cantidadSimulacion);
    String calcularEntropiaFuenteMemNula(ArrayList<Double> probabilidades,int cantidadSimulacion);

    String calcularMatrizEntropiaFuenteMarkov(String nombreArchivo,int cantidadSimulacion);
    String calcularMatrizEntropiaFuenteMarkov(double[][] matrizProbabilidades, int cantidadSimulacion);
    
    String calcularCodigosInstantaneos(String nombreArchivo,int cantidadSimulacion);
    String calcularCodigosInstantaneos(ArrayList<Double> probabilidades,int cantidadSimulacion);
}
