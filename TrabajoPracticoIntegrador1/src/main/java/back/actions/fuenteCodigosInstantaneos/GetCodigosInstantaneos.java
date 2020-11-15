package back.actions.fuenteCodigosInstantaneos;

import java.util.ArrayList;

import back.actions.Actionable;
import back.domain.calculadoras.CalculadoraCantInformacion;
import back.domain.calculadoras.CalculadoraCodigosInstantaneos;
import back.domain.calculadoras.CalculadoraDeSimulacionFuenteNulaConCodigos;
import back.domain.calculadoras.CalculadoraEntropia;
import back.domain.calculadoras.CalculadoraLongitudCodigos;
import back.domain.calculadoras.CalculadoraPropiedades;
import back.domain.formatters.CodigosInstantaneosFormatter;

public class GetCodigosInstantaneos implements Actionable {

	private final ArrayList<Double> probabilidades;
	private final int cantidadDeIteraciones;
	private final CalculadoraCantInformacion calculadoraCantInformacion = new CalculadoraCantInformacion();
	private final CalculadoraEntropia calculadoraEntropia = new CalculadoraEntropia();
	private final CalculadoraCodigosInstantaneos calculadoraCodigos = new CalculadoraCodigosInstantaneos();
	private final CalculadoraLongitudCodigos calculadoraLongitud = new CalculadoraLongitudCodigos();
	private final CalculadoraPropiedades calculadoraPropiedades = new CalculadoraPropiedades();
	private final CodigosInstantaneosFormatter formatter = new CodigosInstantaneosFormatter();
	private final CalculadoraDeSimulacionFuenteNulaConCodigos calculadoraSimulacion = new CalculadoraDeSimulacionFuenteNulaConCodigos();

	public GetCodigosInstantaneos(ArrayList<Double> probabilidades) {
		this.probabilidades = probabilidades;
		this.cantidadDeIteraciones = 1000;
	}

	@Override
	public String execute() {
		ArrayList<Double> infosIndividuales = calculadoraCantInformacion.invoke(probabilidades);
		ArrayList<Double> entropiasIndividuales = calculadoraEntropia.calculaEntropiaIndividual(probabilidades,
				infosIndividuales);
		double entropia = calculadoraEntropia.calculaEntropia(entropiasIndividuales);
		ArrayList<String> codigos = calculadoraCodigos.invoke(probabilidades);

		String simulacionSimbolos = calculadoraSimulacion.simulaSimbolos(probabilidades, cantidadDeIteraciones);
		String simulacionCodigos = calculadoraSimulacion.simulaCodigos(simulacionSimbolos, codigos);
		ArrayList<Integer> aparicionesSimulacion = calculadoraSimulacion.cuentaApariciones(simulacionSimbolos,
				probabilidades.size());
		ArrayList<Double> probabilidadesSimuladas = calculadoraSimulacion.calculaProbabilidades(aparicionesSimulacion,
				cantidadDeIteraciones);
		ArrayList<Double> infosIndividualesSimuladas = calculadoraCantInformacion.invoke(probabilidadesSimuladas);
		ArrayList<Double> entropiasIndividualesSimuladas = calculadoraEntropia
				.calculaEntropiaIndividual(probabilidadesSimuladas, infosIndividualesSimuladas);
		double entropiaSimulada = calculadoraEntropia.calculaEntropia(entropiasIndividualesSimuladas);

		ArrayList<Integer> longitudesIndividuales = calculadoraLongitud.invoke(codigos);
		double longitudMedia = calculadoraLongitud.invoke(longitudesIndividuales, probabilidades);
		double longitudMediaSimulada = calculadoraLongitud.invoke(longitudesIndividuales, probabilidadesSimuladas);

		String kraft = calculadoraPropiedades.invoke(longitudesIndividuales);
		String compacto = calculadoraPropiedades.invoke(infosIndividuales, longitudesIndividuales);
		String compactoSimulado = calculadoraPropiedades.invoke(infosIndividualesSimuladas,longitudesIndividuales);
		return formatter.format(codigos, probabilidades, infosIndividuales, entropiasIndividuales, entropia,
				longitudesIndividuales, longitudMedia, kraft, compacto, simulacionSimbolos, simulacionCodigos,
				aparicionesSimulacion, probabilidadesSimuladas, infosIndividualesSimuladas,
				entropiasIndividualesSimuladas, entropiaSimulada, longitudMediaSimulada,compactoSimulado);
	}
}
