package front.controladores;

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
            // TODO: Aca poner lo de canales
        } else if (command.equalsIgnoreCase(IVistaGeneral.CODIFICACIONES)) {
            // TODO: Aca poner lo de codificaciones
        }
    }
}
