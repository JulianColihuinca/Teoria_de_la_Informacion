package front.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import back.presentation.Codificaciones;
import back.presentation.ICodificaciones;
import front.views.interfaces.IVistaCodificaciones;

public class ControladorCodificaciones implements ActionListener{

	private IVistaCodificaciones vista;
	private ICodificaciones codificacion;

	public ControladorCodificaciones(IVistaCodificaciones vista) {
		this.vista = vista;
		this.vista.setActionlistener(this);
		this.codificacion = new Codificaciones();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("Codificar Huffman")) 
			this.vista.setAreaInfo(this.codificacion.codificarHuffman(this.vista.getTextoACodificar()));
		else if (comando.equalsIgnoreCase("Codificar Shannon-Fano"))
			this.vista.setAreaInfo(this.codificacion.codificarShannonFano(this.vista.getTextoACodificar()));
		else if (comando.equalsIgnoreCase("Codificar RLC"))
			this.vista.setAreaInfo(this.codificacion.codificarRLC(this.vista.getTextoACodificar()));
	}
}
