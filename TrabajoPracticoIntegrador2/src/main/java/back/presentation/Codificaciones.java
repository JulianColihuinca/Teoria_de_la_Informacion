package back.presentation;

import back.actions.Actionable;
import back.actions.huffman.GetCodificacionHuffman;
import back.actions.rlc.GetCodificacionRLC;
import back.actions.shannonfano.GetCodificacionShannonFano;

public class Codificaciones implements ICodificaciones{

	@Override
	public String codificarHuffman(String textoACodificar) {
		Actionable action = new GetCodificacionHuffman(textoACodificar);
		return action.execute();
	}

	@Override
	public String codificarShannonFano(String textoACodificar) {
		Actionable action = new GetCodificacionShannonFano(textoACodificar);
		return action.execute();
	}
	
	@Override
	public String codificarRLC(String textoACodificar) {
		Actionable action = new GetCodificacionRLC(textoACodificar);
		return action.execute();
	}

}
