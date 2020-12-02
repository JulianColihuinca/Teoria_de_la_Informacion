package back.presentation;

public interface ICodificaciones {
	
	String codificarHuffman(String textoACodificar);
	
	String codificarShannonFano(String textoACodificar);

	String codificarRLC(String textoACodificar);

}
