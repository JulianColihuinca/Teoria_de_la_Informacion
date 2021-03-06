package back.actions.fuenteMarkov;

import java.util.ArrayList;

import back.actions.Actionable;
import back.domain.calculadoras.CalculadoraDeSimulacionFuenteMarkov;
import back.domain.calculadoras.CalculadoraEntropia;
import back.domain.calculadoras.CalculadoraMatrizInformacion;
import back.domain.calculadoras.CalculadoraVectorEstacionario;
import back.domain.formatters.FuenteMarkovFormatter;

public class GetEntropiaFuenteMarkov implements Actionable {
	private double[][] matrizProbabilidades;
	private final int cantidadDeIteraciones;
	private final CalculadoraMatrizInformacion calculadoraMatrizInformacion = new CalculadoraMatrizInformacion();
	private final CalculadoraVectorEstacionario calculadoraVectorEstacionario = new CalculadoraVectorEstacionario();
	private final CalculadoraEntropia calculadoraEntropia = new CalculadoraEntropia();
	private final FuenteMarkovFormatter formatter = new FuenteMarkovFormatter();
	private final CalculadoraDeSimulacionFuenteMarkov calculadoraSimulacion = new CalculadoraDeSimulacionFuenteMarkov();

	public GetEntropiaFuenteMarkov(double[][] matrizProbabilidades,int cantidad) {
		this.matrizProbabilidades = matrizProbabilidades;
		this.cantidadDeIteraciones=cantidad;
	}

	@Override
	public String execute() {
		String simulacion = calculadoraSimulacion.invoke(matrizProbabilidades, this.cantidadDeIteraciones);
		ArrayList<Integer> aparicionesSimulacion = calculadoraSimulacion.invoke(simulacion,
				matrizProbabilidades.length);
		double[][] matrizApariciones = calculadoraSimulacion.matrizApariciones(simulacion, matrizProbabilidades.length);
		double[][] matrizTransicionSimulada = calculadoraSimulacion.matrizTransicion(matrizApariciones);
		double[][] matrizInformacion = calculadoraMatrizInformacion.invoke(matrizProbabilidades);
		double[][] matrizInformacionSimulada = calculadoraMatrizInformacion.invoke(matrizTransicionSimulada);
		double[] vectorEstacionario = calculadoraVectorEstacionario.invoke(matrizProbabilidades);
		double[] vectorEstacionarioSimulado = calculadoraVectorEstacionario.invoke(matrizTransicionSimulada);
		double entropia = calculadoraEntropia.calculaEntropia(matrizProbabilidades, matrizInformacion,
				vectorEstacionario);
		double entropiaSimulada = calculadoraEntropia.calculaEntropia(matrizTransicionSimulada,
				matrizInformacionSimulada, vectorEstacionarioSimulado);
		return formatter.format(matrizProbabilidades, matrizInformacion, vectorEstacionario, entropia, simulacion,
				aparicionesSimulacion, matrizTransicionSimulada, matrizInformacionSimulada, vectorEstacionarioSimulado,
				entropiaSimulada,matrizApariciones,this.cantidadDeIteraciones);
	}
}
