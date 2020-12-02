package main;

import front.controladores.ControladorGeneral;
import front.views.VistaGeneral;
import front.views.interfaces.IVistaGeneral;

public class Main {

    public static void main(String[] args) {
        IVistaGeneral vista = new VistaGeneral();
        ControladorGeneral controlador = new ControladorGeneral(vista);
        vista.setControlador(controlador);
        vista.abrir();
    }
}
