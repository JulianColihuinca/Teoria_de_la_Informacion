package front.views.interfaces;

import java.awt.event.ActionListener;

public interface IVistaCodificaciones {

void setActionlistener(ActionListener controlador);
	
	void setAreaInfo(String info);
	
	String getTextoACodificar();
	
	void abrir();
	
}
