package front.views.interfaces;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface IVistaCanales {

	void setActionlistener(ActionListener controlador);
	
	double[] getProbabilidadesAPriori();
	
	double[][] getMatrizCanal();
	
	void setAreaInfo(String info);
	
	void abrir();
	
}
