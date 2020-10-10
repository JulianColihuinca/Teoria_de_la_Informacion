package back.actions.fuenteMarkov;

import back.actions.Actionable;
import back.domain.calculadoras.CalculadoraEntropia;
import back.domain.calculadoras.CalculadoraMatrizInformacion;
import back.domain.calculadoras.CalculadoraVectorEstacionario;
import back.domain.formatters.FuenteMarkovFormatter;

public class GetEntropiaFuenteMarkov implements Actionable {
    private double[][] matrizProbabilidades;
    private final CalculadoraMatrizInformacion calculadoraMatrizInformacion = new CalculadoraMatrizInformacion();
    private final CalculadoraVectorEstacionario calculadoraVectorEstacionario = new CalculadoraVectorEstacionario();
    private final CalculadoraEntropia calculadoraEntropia = new CalculadoraEntropia();
    private final FuenteMarkovFormatter formatter = new FuenteMarkovFormatter();

    public GetEntropiaFuenteMarkov(double[][] matrizProbabilidades) {
        this.matrizProbabilidades = matrizProbabilidades;
    }

    @Override
    public String execute() {
        double[][] matrizInformacion = calculadoraMatrizInformacion.invoke(matrizProbabilidades);
        double[] vectorEstacionario = calculadoraVectorEstacionario.invoke(matrizProbabilidades);
        double entropia = calculadoraEntropia.calculaEntropia(matrizProbabilidades, matrizInformacion, vectorEstacionario);
        return formatter.format(matrizProbabilidades, matrizInformacion, vectorEstacionario, entropia);
    }
}
