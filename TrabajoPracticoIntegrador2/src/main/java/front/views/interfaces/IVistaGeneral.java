package front.views.interfaces;

import java.awt.event.ActionListener;

public interface IVistaGeneral {
    static final String CANALES = "Canales";
    static final String CODIFICACIONES = "Codificaciones";

    public void abrir();
    public void setControlador(ActionListener actionListener);
}
