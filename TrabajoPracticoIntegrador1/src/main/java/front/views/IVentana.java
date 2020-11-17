package front.views;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface IVentana {
    void abrir();

    String getFuenteSeleccionada();

    int getCantFuentes();

    double[][] getMatriz();

    ArrayList<Double> getArray();

    String getDireccion();
    
    int getN();

    void dibujaVector(int cant);

    void dibujaMatriz(int cant);

    void setAreaInformacion(String ver_resultados);

    void setActionlistener(ActionListener controlador);
    
    boolean porArchivo();
    
   
}
