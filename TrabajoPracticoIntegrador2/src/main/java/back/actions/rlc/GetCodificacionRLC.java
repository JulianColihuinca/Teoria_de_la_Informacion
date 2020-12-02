package back.actions.rlc;

import back.actions.Actionable;
import back.domain.calculadoras.CalculadoraRLC;
import back.domain.formatters.RlcFormatter;
import back.domain.interfaces.ICalculadoraRLC;

public class GetCodificacionRLC implements Actionable{

	private String textoCodificado;
	private String textoIngresado;
	private int tasaDeCompresionEntera;
	private double tasaDeCompresion;
	private ICalculadoraRLC calculadora = new CalculadoraRLC(); 
	private RlcFormatter formatter = new RlcFormatter();
	
	public GetCodificacionRLC(String textoACodificar) {
		this.textoIngresado = textoACodificar;
	}
	
	@Override
	public String execute() {
		this.textoCodificado = calculadora.analizarTexto(textoIngresado);
		this.tasaDeCompresionEntera = calculadora.tasaDeCompresionEntera(textoIngresado,textoCodificado);
		this.tasaDeCompresion = calculadora.tasaDeCompresion(textoIngresado, textoCodificado);

		return formatter.format(this.textoCodificado,this.tasaDeCompresionEntera,this.tasaDeCompresion);
	}

}
