package back.actions;

import back.domain.formatters.FuenteMemoriaNulaResultFormatter;
import back.infrastructure.LectorArchivo;
import back.domain.calculadoras.CalculadoraCantInformacion;
import back.domain.calculadoras.CalculadoraEntropia;

import java.util.ArrayList;

public class GetResultadoPorArchivoFuenteMemoriaNulaAction implements Actionable {
    private final String nombreArchivo;
    private final LectorArchivo lector = new LectorArchivo();
    private final CalculadoraCantInformacion calculadoraCantInformacion = new CalculadoraCantInformacion();
    private final CalculadoraEntropia calculadoraEntropia = new CalculadoraEntropia();
    private final FuenteMemoriaNulaResultFormatter formatter = new FuenteMemoriaNulaResultFormatter();

    public GetResultadoPorArchivoFuenteMemoriaNulaAction(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String execute() {
        return calculaEntropia(nombreArchivo);
    }

    private String calculaEntropia(String nombreArchivo) {
        ArrayList<Double> probabilidades = lector.leer(nombreArchivo);
        ArrayList<Double> infosIndividuales = calculadoraCantInformacion.invoke(probabilidades);
        ArrayList<Double> entropiasIndividuales = calculadoraEntropia.calculaEntropiaIndividual(probabilidades, infosIndividuales);
        double entropia = calculadoraEntropia.calculaEntropia(entropiasIndividuales);
        return formatter.formatResultado(probabilidades, infosIndividuales, entropiasIndividuales, entropia);
    }
}
