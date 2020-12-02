package back.domain.interfaces;


public interface ICalculadoraRLC {

	String analizarTexto(String cadena);

	int tasaDeCompresionEntera(String textoIngresado, String textoCodificado);
	
	double tasaDeCompresion(String textoIngresado, String textoCodificado);
}
