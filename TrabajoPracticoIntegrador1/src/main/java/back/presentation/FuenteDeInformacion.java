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
    public String calcularEntropiaFuenteMemNula(String nombreArchivo) {
        Actionable action = new GetEntropiaPorArchivoFuenteMemoriaNulaAction(nombreArchivo);
        return action.execute();
    }

    @Override
    public String calcularEntropiaFuenteMemNula(ArrayList<Double> probabilidades) {
        Actionable action = new GetEntropiaFuenteMemoriaNula(probabilidades);
        return action.execute();
    }

    @Override
    public String calcularMatrizEntropiaFuenteMarkov(String nombreArchivo) {
        Actionable action = new GetEntropiaPorArchivoFuenteMarkov(nombreArchivo);
        return action.execute();
    }

    @Override
    public String calcularMatrizEntropiaFuenteMarkov(double[][] matrizProbabilidades) {
        Actionable action = new GetEntropiaFuenteMarkov(matrizProbabilidades);
        return action.execute();
    }
    
    @Override
    public String calcularCodigosInstantaneos(String nombreArchivo) {
    	Actionable action = new GetCodigosInstantaneosPorArchivo(nombreArchivo);
    	return action.execute();
    }
    
    @Override
    public String calcularCodigosInstantaneos(ArrayList<Double> probabilidades) {
    	Actionable action = new GetCodigosInstantaneos(probabilidades);
    	return action.execute();
    }
}
