package back.actions.fuenteMemoriaNula;

import back.actions.Actionable;
import back.domain.calculadoras.CalculadoraCantInformacion;
import back.domain.calculadoras.CalculadoraEntropia;
import back.domain.formatters.FuenteMemoriaNulaResultFormatter;

import java.util.ArrayList;

public class GetEntropiaFuenteMemoriaNula implements Actionable  {
    private final ArrayList<Double> probabilidades;
    private final CalculadoraCantInformacion calculadoraCantInformacion = new CalculadoraCantInformacion();
    private final CalculadoraEntropia calculadoraEntropia = new CalculadoraEntropia();
    private final FuenteMemoriaNulaResultFormatter formatter = new FuenteMemoriaNulaResultFormatter();

    public GetEntropiaFuenteMemoriaNula(ArrayList<Double> probabilidades) {
        this.probabilidades = probabilidades;
    }

    @Override
    public String execute() {
        ArrayList<Double> infosIndividuales = calculadoraCantInformacion.invoke(probabilidades);
        ArrayList<Double> entropiasIndividuales = calculadoraEntropia.calculaEntropiaIndividual(probabilidades, infosIndividuales);
        double entropia = calculadoraEntropia.calculaEntropia(entropiasIndividuales);
        return formatter.format(probabilidades, infosIndividuales, entropiasIndividuales, entropia);
    }
}
