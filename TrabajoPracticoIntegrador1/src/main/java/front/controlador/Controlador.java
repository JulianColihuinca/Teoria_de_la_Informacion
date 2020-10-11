package front.controlador;

import back.presentation.FuenteDeInformacion;
import back.presentation.IFuenteDeInformacion;
import front.views.IVentana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    private IVentana ventana;
    private IFuenteDeInformacion fuenteDeInformacion;

    public Controlador(IVentana ventana) {
        this.ventana = ventana;
        fuenteDeInformacion = new FuenteDeInformacion();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        String commando= arg0.getActionCommand();
        if (commando.equalsIgnoreCase("INGRESO FUENTE")) {
            if (this.ventana.getFuenteSeleccionada().equalsIgnoreCase("Fuente con memoria nula")) 
                this.ventana.dibujaVector(this.ventana.getCantFuentes());
            else if (this.ventana.getFuenteSeleccionada().equalsIgnoreCase("Fuente de Markov")) 
                this.ventana.dibujaMatriz(this.ventana.getCantFuentes());
            
        }
        else if (commando.equalsIgnoreCase("VER RESULTADOS")) {
            if (this.ventana.porArchivo() && this.ventana.getFuenteSeleccionada().equalsIgnoreCase("Fuente con memoria nula")) 
            	 this.ventana.setAreaInformacion(this.fuenteDeInformacion.calcularEntropiaFuenteMemNula(this.ventana.getDireccion()));
            else if (this.ventana.porArchivo() && this.ventana.getFuenteSeleccionada().equals("Fuente de Markov"))
            	this.ventana.setAreaInformacion(this.fuenteDeInformacion.calcularMatrizEntropiaFuenteMarkov(this.ventana.getDireccion()));
            else if (!this.ventana.porArchivo() && this.ventana.getFuenteSeleccionada().equalsIgnoreCase("Fuente con memoria nula"))
            	 this.ventana.setAreaInformacion(this.fuenteDeInformacion.calcularEntropiaFuenteMemNula(this.ventana.getArray()));
            else if (!this.ventana.porArchivo() && this.ventana.getFuenteSeleccionada().equals("Fuente de Markov"))
            	 this.ventana.setAreaInformacion(this.fuenteDeInformacion.calcularMatrizEntropiaFuenteMarkov(this.ventana.getMatriz()));
        }
    }

}
