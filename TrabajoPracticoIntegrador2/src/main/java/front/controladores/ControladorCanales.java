package front.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import back.presentation.Canal;
import back.presentation.ICanal;
import front.views.interfaces.IVistaCanales;

public class ControladorCanales implements ActionListener {

	private IVistaCanales vista;
	private ICanal canal;

	public ControladorCanales(IVistaCanales vista) {
		this.vista = vista;
		this.vista.setActionlistener(this);
		this.canal = new Canal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("Enviar mensaje"))
			this.vista.setAreaInfo(
					this.canal.enviarMensaje(this.vista.getProbabilidadesAPriori(), this.vista.getMatrizCanal()));
	}

}
