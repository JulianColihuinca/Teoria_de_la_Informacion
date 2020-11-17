package back.presentation;

import back.actions.Actionable;
import back.actions.fuenteCodigosInstantaneos.GetCodigosInstantaneos;
import back.actions.fuenteCodigosInstantaneos.GetCodigosInstantaneosPorArchivo;
import back.actions.fuenteMarkov.GetEntropiaFuenteMarkov;
import back.actions.fuenteMarkov.GetEntropiaPorArchivoFuenteMarkov;
import back.actions.fuenteMemoriaNula.GetEntropiaFuenteMemoriaNula;
import back.actions.fuenteMemoriaNula.GetEntropiaPorArchivoFuenteMemoriaNulaAction;

import java.util.ArrayList;

public class FuenteDeInformacion implements IFuenteDeInformacion {

    @Override
    public String calcularEntropiaFuenteMemNula(String nombreArchivo,int cantidad) {
        Actionable action = new GetEntropiaPorArchivoFuenteMemoriaNulaAction(nombreArchivo,cantidad);
        return action.execute();
    }

    @Override
    public String calcularEntropiaFuenteMemNula(ArrayList<Double> probabilidades,int cantidadSimulacion) {
        Actionable action = new GetEntropiaFuenteMemoriaNula(probabilidades,cantidadSimulacion);
        return action.execute();
    }

    @Override
    public String calcularMatrizEntropiaFuenteMarkov(String nombreArchivo,int cantidad) {
        Actionable action = new GetEntropiaPorArchivoFuenteMarkov(nombreArchivo,cantidad);
        return action.execute();
    }

    @Override
    public String calcularMatrizEntropiaFuenteMarkov(double[][] matrizProbabilidades,int cantidadSimulacion) {
        Actionable action = new GetEntropiaFuenteMarkov(matrizProbabilidades,cantidadSimulacion);
        return action.execute();
    }
    
    @Override
    public String calcularCodigosInstantaneos(String nombreArchivo,int cantidad) {
    	Actionable action = new GetCodigosInstantaneosPorArchivo(nombreArchivo,cantidad);
    	return action.execute();
    }
    
    @Override
    public String calcularCodigosInstantaneos(ArrayList<Double> probabilidades, int cantidadSimulacion) {
    	Actionable action = new GetCodigosInstantaneos(probabilidades,cantidadSimulacion);
    	return action.execute();
    }
}
