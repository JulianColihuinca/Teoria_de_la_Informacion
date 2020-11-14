package back.actions.fuenteMemoriaNula;

import back.actions.Actionable;
import back.domain.calculadoras.CalculadoraCantInformacion;
import back.domain.calculadoras.CalculadoraDeSimulacionFuenteNula;
import back.domain.calculadoras.CalculadoraEntropia;
import back.domain.formatters.FuenteMemoriaNulaResultFormatter;

import java.util.ArrayList;

public class GetEntropiaFuenteMemoriaNula implements Actionable {
	private final ArrayList<Double> probabilidades;
	private final CalculadoraCantInformacion calculadoraCantInformacion = new CalculadoraCantInformacion();
	private final CalculadoraEntropia calculadoraEntropia = new CalculadoraEntropia();
	private final FuenteMemoriaNulaResultFormatter formatter = new FuenteMemoriaNulaResultFormatter();
	private final CalculadoraDeSimulacionFuenteNula calculadoraSimulacion = new CalculadoraDeSimulacionFuenteNula();

	public GetEntropiaFuenteMemoriaNula(ArrayList<Double> probabilidades) {
		this.probabilidades = probabilidades;
	}

	@Override
	public String execute() {
		String simulacion = calculadoraSimulacion.invoke(probabilidades, 1000);
		ArrayList<Integer> aparicionesSimulacion = calculadoraSimulacion.invoke(simulacion, probabilidades.size());
		ArrayList<Double> probabilidadesSimuladas = calculadoraSimulacion.invoke(aparicionesSimulacion);
		ArrayList<Double> infosIndividuales = calculadoraCantInformacion.invoke(probabilidades);
		ArrayList<Double> infosIndividualesSimuladas = calculadoraCantInformacion.invoke(probabilidadesSimuladas);
		ArrayList<Double> entropiasIndividuales = calculadoraEntropia.calculaEntropiaIndividual(probabilidades,
				infosIndividuales);
		ArrayList<Double> entropiasIndividualesSimuladas = calculadoraEntropia
				.calculaEntropiaIndividual(probabilidadesSimuladas, infosIndividualesSimuladas);
		double entropia = calculadoraEntropia.calculaEntropia(entropiasIndividuales);
		double entropiaSimulada = calculadoraEntropia.calculaEntropia(entropiasIndividualesSimuladas);
		return formatter.format(probabilidades, infosIndividuales, entropiasIndividuales, entropia, simulacion,
				probabilidadesSimuladas, aparicionesSimulacion, infosIndividualesSimuladas,
				entropiasIndividualesSimuladas, entropiaSimulada);
	}
}
