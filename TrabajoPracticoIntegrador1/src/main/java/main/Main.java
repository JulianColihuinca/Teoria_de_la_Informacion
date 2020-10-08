package main;

import front.controlador.Controlador;
import front.views.IVentana;
import front.views.Ventana;

public class Main {
    public static void main(String[] args) {
        IVentana ventana = new Ventana();
        Controlador controlador = new Controlador(ventana);
        ventana.setActionlistener(controlador);
        ventana.abrir();
    }
}
