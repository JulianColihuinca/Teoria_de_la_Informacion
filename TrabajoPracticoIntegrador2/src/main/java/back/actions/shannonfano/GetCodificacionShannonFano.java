package back.actions.shannonfano;

import java.util.ArrayList;

import back.actions.Actionable;
import back.domain.calculadoras.CalculadoraShannonFano;
import back.domain.formatters.ShannonFanoFormatter;
import back.domain.interfaces.ICalculadoraShannonFano;

public class GetCodificacionShannonFano implements Actionable {

	private ArrayList<Character> simbolos = new ArrayList<Character>();
	private ArrayList<Integer> frecuenciaSimbolos = new ArrayList<Integer>();
	private ArrayList<Double> probabilidades = new ArrayList<Double>();
	private ArrayList<String> codigos = new ArrayList<String>();
	private double entropia;
	private double longitudMedia;
	private String textoIngresado;
	private int tasaDeCompresionEntera;
	private double tasaDeCompresion;
	private ICalculadoraShannonFano calculadora = new CalculadoraShannonFano();
	private ShannonFanoFormatter formatter = new ShannonFanoFormatter();

	public GetCodificacionShannonFano(String textoACodificar) {
		this.textoIngresado = textoACodificar;
	}

	@Override
	public String execute() {

		calculadora.analizarTexto(textoIngresado, simbolos, frecuenciaSimbolos, probabilidades, codigos);
		this.entropia = calculadora.calculaEntropia(probabilidades);
		this.longitudMedia = calculadora.calculaLongitudMedia(codigos, probabilidades);
		this.tasaDeCompresionEntera = calculadora.tasaDeCompresionEntera(textoIngresado, simbolos, frecuenciaSimbolos,
				codigos);
		this.tasaDeCompresion = calculadora.tasaDeCompresion(textoIngresado, simbolos, frecuenciaSimbolos, codigos);

		return formatter.format(simbolos, frecuenciaSimbolos, probabilidades, codigos, entropia, longitudMedia,
				tasaDeCompresionEntera,tasaDeCompresion);
	}

}
