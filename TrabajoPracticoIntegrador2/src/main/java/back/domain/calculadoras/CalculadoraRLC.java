package back.domain.calculadoras;

import back.domain.interfaces.ICalculadoraRLC;

public class CalculadoraRLC implements ICalculadoraRLC {

	@Override
	public String analizarTexto(String cadena) {
		String codificacion = "";
		int contador = 1;
		char aux = cadena.charAt(0);
		codificacion += aux;
		for (int i = 1; i < cadena.length(); i++) {
			if (cadena.charAt(i) == aux)
				contador++;
			else {
				codificacion += String.valueOf(contador);
				aux = cadena.charAt(i);
				contador = 1;
				codificacion += aux;
			}
		}
		codificacion += contador;

		return codificacion;
	}

	@Override
	public int tasaDeCompresionEntera(String textoIngresado, String textoCodificado) {
		return (int) ((double) textoIngresado.length() / (double)textoCodificado.length());
	}
	
	@Override
	public double tasaDeCompresion(String textoIngresado, String textoCodificado) {
		return ((double) textoIngresado.length() / (double)textoCodificado.length());
	}

}
