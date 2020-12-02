package front.controladores;

import front.views.VistaCanales;
import front.views.VistaCodificaciones;
import front.views.interfaces.IVistaCanales;
import front.views.interfaces.IVistaCodificaciones;
import front.views.interfaces.IVistaGeneral;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorGeneral implements ActionListener {
    private IVistaGeneral vista;

    public ControladorGeneral(IVistaGeneral vista) {
        this.vista = vista;
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equalsIgnoreCase(IVistaGeneral.CANALES)) {
        	IVistaCanales vista = new VistaCanales();
        	ControladorCanales controlador = new ControladorCanales(vista);
        	vista.abrir();
        	//this.vista.cerrar();
        } else if (command.equalsIgnoreCase(IVistaGeneral.CODIFICACIONES)) {
        	IVistaCodificaciones vista = new VistaCodificaciones();
        	ControladorCodificaciones controlador = new ControladorCodificaciones(vista);
        	vista.abrir();
        	//this.vista.cerrar();
        }
    }
}
