package front.views;

import java.awt.event.ActionListener;

public interface IVentana {
    void abrir();

    String getFuenteSeleccionada();

    int getCantFuentes();

    double[][] getMatriz();

    double[] getVector();

    String getDireccion();

    void dibujaVector(int cant);

    void dibujaMatriz(int cantFuentes);

    void setAreaInformacion(String ver_resultados);

    void setActionlistener(ActionListener controlador);
}
