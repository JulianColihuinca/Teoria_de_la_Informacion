package back.actions.huffman;

import java.io.IOException;
import java.util.ArrayList;

import back.actions.Actionable;
import back.domain.calculadoras.CalculadoraHuffman;
import back.domain.formatters.HuffmanFormatter;
import back.domain.interfaces.ICalculadoraHuffman;

public class GetCodificacionHuffman implements Actionable {

	private ArrayList<Character> simbolos = new ArrayList<Character>();
	private ArrayList<Integer> frecuenciaSimbolos = new ArrayList<Integer>();
	private ArrayList<Double> probabilidades = new ArrayList<Double>();
	private ArrayList<String> codigos = new ArrayList<String>();
	private double entropia;
	private double longitudMedia;
	private String textoIngresado;
	private int tasaDeCompresionEntera;
	private double tasaDeCompresion;
	private ICalculadoraHuffman calculadora = new CalculadoraHuffman();
	private HuffmanFormatter formatter = new HuffmanFormatter();

	public GetCodificacionHuffman(String textoACodificar) {
		this.textoIngresado = textoACodificar;
	}

	@Override
	public String execute() {
		
		try {
			calculadora.analizarTexto(textoIngresado, simbolos, frecuenciaSimbolos, probabilidades, codigos);
			this.entropia= calculadora.calculaEntropia(probabilidades);
			this.longitudMedia = calculadora.calculaLongitudMedia(codigos,probabilidades);
			this.tasaDeCompresionEntera = calculadora.tasaDeCompresionEntera(textoIngresado, simbolos, frecuenciaSimbolos, codigos);
			this.tasaDeCompresion = calculadora.tasaDeCompresion(textoIngresado, simbolos, frecuenciaSimbolos, codigos);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return formatter.format(simbolos, frecuenciaSimbolos, probabilidades, codigos, entropia, longitudMedia,tasaDeCompresionEntera,tasaDeCompresion);
	}

}
